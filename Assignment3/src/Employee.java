/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 3
*/

public class Employee {
    private String name;
    private int id;
    private static int idCount = 0;

    Employee(){
        idCount++;
        name = "New Employee";
        id = idCount;
    }

    Employee(String n){
        idCount++;
        name = n;
        id = idCount;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int i){
        this.id = i;
    }

    public static int getIdCount(){
        return idCount;
    }

    public static void lowerEmployeeCount(){
        idCount--;
    }
}
