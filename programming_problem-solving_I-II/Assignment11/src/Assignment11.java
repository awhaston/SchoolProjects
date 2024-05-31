/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 11
*/

public class Assignment11 {
    public static void main(String[] args) {
        CreditCard cardOne = new CreditCard();

        Thread t1 = new Thread(new CardHolder(cardOne));
        t1.setName("John");

        Thread t2 = new Thread(new CardHolder(cardOne));
        t2.setName("Mary");

        t1.start();
        t2.start();
    }
}
