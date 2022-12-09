/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 3
*/

public class Faculty extends Employee{
    private double salary;
    private double stipend;
    private double pay;

    Faculty(String n, double sal, double stip){
        setName(n);
        salary = sal;
        stipend = stip;

    }

    public void setSalary(double sal){
        this.salary = sal;
    }

    public double getSalary(){
        return this.salary;
    }

    public void setStipend(double stip){
        this.stipend = stip;
    }

    public double getStipend(){
        return this.stipend;
    }

    public void setPay(double p){
        this.pay = p;
    }

    public double getPay(){
        return this.pay;
    }

    public void calculatePay(){
        this.pay = this.salary + this.stipend;
    }

    public String toString(){
        return "Name: " + this.getName() + " Salary: " + this.salary + " Stipend: " + this.stipend + " Weekly Pay: " + pay;
    }
}
