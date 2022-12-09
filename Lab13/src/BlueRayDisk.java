/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 13
*/

public class BlueRayDisk {
    private String title;
    private String director;
    private int year;
    private double cost;

    public BlueRayDisk(String title, String director, int year, double cost) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "$" + this.cost + this.year + " " + this.title + ", " + this.director;
    }
}
