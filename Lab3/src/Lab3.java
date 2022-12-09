/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 3
*/

import java.util.*;

public class Lab3 {
    public static void main(String args[]){
        boolean quit = false;
        int choice;
        Scanner scan = new Scanner(System.in);
        Quiz quiz = new Quiz();

        do{
            System.out.println(
                    "Please choose an option:\n" +
                    "1. Add a question to the quiz\n" +
                    "2. Remove a question from the quiz\n" +
                    "3. Modify a question in the quiz\n" +
                    "4. Take the quiz\n" +
                    "5. Quit");
            choice = scan.nextInt();
            switch(choice){
                case 1:
                    quiz.addQuestion();
                    break;
                case 2:
                    quiz.removeQuestion();
                    break;
                case 3:
                    quiz.modifyQuestion();
                    break;
                case 4:
                    quiz.takeQuiz();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Error! Invalid input detected");
                    break;
            }
        }while(quit == false);
    }
}
