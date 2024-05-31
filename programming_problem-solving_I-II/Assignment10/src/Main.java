/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 10
*/

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter the name of the input file: ");
        String fileName = scan.nextLine();
        File file = null;

        try {
            file = new File("/Users/wyatthaston/IdeaProjects/Assignment10/src/" + fileName);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        processFile(file);
    }

    public static void processFile(File file) throws IOException {
        FileWriter writer = new FileWriter("/Users/wyatthaston/IdeaProjects/Assignment10/src/FinalGradesFile.txt");
        FileWriter errorWriter = new FileWriter("/Users/wyatthaston/IdeaProjects/Assignment10/src/ErrorGradesFile.txt");
        try{
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){

                boolean ignoreFinal = false;
                double totalQuizScore = 0;
                double averageQuizScore = 0;
                double quizScore = 0;
                double lowestQuizScore = 100;
                double testOneScore = 0;
                double testTwoScore = 0;
                double finalExamScore = 0;
                double finalGrade = 0;
                boolean errorStudent = false;
                String line = scan.nextLine();
                String[] studentRaw = line.split(",");
                String studentName = studentRaw[0];
                String studentId = studentRaw[1];
                if(Objects.equals(studentId, "") || Objects.equals(studentName, "")){
                    errorStudent = true;
                    errorWriter.write(studentName);
                    errorWriter.close();
                    throw new Exception("Invalid student format, writing to error file");
                }

                for(int i = 0; i < studentRaw.length; i++){
                    if(studentRaw[i].contains("-1")){
                        ignoreFinal = true;

                    }
                    if(i > 1 && i < 12){
                        quizScore = Double.parseDouble(studentRaw[i]);
                        totalQuizScore += quizScore;
                        if(quizScore > lowestQuizScore){
                            lowestQuizScore = quizScore;
                        }
                    }
                    if(i == 12){
                        if(Double.parseDouble(studentRaw[i]) == -1){
                            testOneScore = 0;
                        } else{
                            testOneScore = Double.parseDouble(studentRaw[i]);
                        }

                    }else if( i == 13){
                        if(Double.parseDouble(studentRaw[i]) == -1){
                            testTwoScore = 0;
                        } else{
                            testTwoScore = Double.parseDouble(studentRaw[i]);
                        }
                    }else if(i == 14){
                        if(Double.parseDouble(studentRaw[i]) == -1){
                            finalExamScore = 0;
                        } else{
                            finalExamScore = Double.parseDouble(studentRaw[i]);
                        }
                    }
                    if(testOneScore < finalExamScore && testTwoScore > testOneScore && !ignoreFinal){
                        testOneScore = finalExamScore;
                    }else if (testTwoScore < finalExamScore && testOneScore > testTwoScore && !ignoreFinal){
                        testTwoScore = finalExamScore;
                    }
                    averageQuizScore = (totalQuizScore - lowestQuizScore) / 10;
                    finalGrade = (averageQuizScore * .25) + (testOneScore * .25) + (testTwoScore * .25) + (finalExamScore * .25);

                }
                writer.write(studentId + " " + studentName + " " + finalGrade + "\n");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            errorWriter.close();
            writer.close();
        }
    }
}
