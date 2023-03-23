/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 1
*/

public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    Triangle(){
        side1 = 3;
        side2 = 4;
        side3 = 5;
    }

    Triangle(double s1, double s2, double s3){
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    public double getArea(){
        double p = (side1 + side2 + side3)/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    public double getHeight(){
        double height;
        double smallest = side1;

        if(side2 < smallest){
            smallest = side2;
        }
        if(side3 < smallest){
            smallest = side3;
        }

        height = (getArea() * 2)/smallest;
        return height;
    }

    public String toString(){
        return "The triangle has sides " + side1 + ", " + side2 + ", and " + side3 + ". It has an area of " +
                getArea() + " and a perimeter of " + getPerimeter() + " and a it's height is " + getHeight();
    }

}
