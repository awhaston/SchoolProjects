/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 11
*/

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File fileOne = new File("/Users/wyatthaston/IdeaProjects/Lab11/src/file1.txt");
        File fileTwo = new File("/Users/wyatthaston/IdeaProjects/Lab11/src/file2.txt");
        try {
            Scanner scanOne = new Scanner(fileOne);
            Scanner scanTwo = new Scanner(fileTwo);
            while (scanOne.hasNextLine() && scanTwo.hasNext()) {
                String lineOne = scanOne.nextLine();
                String lineTwo = scanTwo.nextLine();
                if (!Objects.equals(lineOne, lineTwo)) {
                    System.out.println("<" + lineOne);
                    System.out.println(">" + lineTwo);
                }
            }
            if (!scanOne.hasNextLine() && scanTwo.hasNextLine() || !scanTwo.hasNextLine() && scanOne.hasNextLine()) {
                throw new RuntimeException("Files are different sizes");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
