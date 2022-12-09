/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 13
*/

public class BlueRayCollection {
    private Node head = null;

    public void add(String title, String director, int year, double cost){
        Node temp = new Node();
        temp.data = new BlueRayDisk(title, director, year, cost);
        temp.next = head;
        head = temp;
    }

    public void showAll(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }
}
