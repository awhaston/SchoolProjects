/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 1
*/

public class Assignment1 {
    public static void main(String args[]){

        for(int i = 1; i < 11; i++){
            Circle circle = new Circle(i);
            System.out.println("Area of a circle with radius of " + i + " is " + circle.getArea() + " circumference is " + circle.getCircumference());
        }

        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++){
                Rectangle rectangle = new Rectangle(i, j);
                System.out.println("Area of a rectangle " + i + " by " + j + " is " +  rectangle.getArea() + " it's perimeter is " + rectangle.getPerimeter());
            }
        }

        Triangle triangle1 = new Triangle(18, 30, 24);
        System.out.println(triangle1.toString());

        Triangle triangle2 = new Triangle();
        System.out.println(triangle2.toString());
    }
}
