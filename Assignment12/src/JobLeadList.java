/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 12
*/

import java.util.Objects;

public class JobLeadList {
    private Node head;
    private Node tail;

    JobLeadList(){
        head = null;
        tail = null;
    }

    public void addToFront(String companyName, String contactName, String contactPhone, String jobTitle, String jobDescription){
        Node temp = new Node();
        temp.lead = new JobLead(companyName, contactName, contactPhone, jobTitle, jobDescription);
        temp.next = head;
        head = temp;
    }

    public void addToTail(String companyName, String contactName, String contactPhone, String jobTitle, String jobDescription){
        Node temp = new Node();
        temp.lead = new JobLead(companyName, contactName, contactPhone, jobTitle, jobDescription);
        temp.next = tail;
        tail = temp;
    }

    public void printHeadToTail(){
        Node temp = head;
        if(Objects.equals(temp.lead, null)){
            System.out.println("List is empty");
            return;
        }
        while(temp != null && !Objects.equals(temp.lead, null)){
            System.out.println(temp.lead.toString());
            temp = temp.next;
        }
        temp = tail;
        while(temp != null && !Objects.equals(temp.lead, null)){
            System.out.println(temp.lead.toString());
            temp = temp.prev;
        }
    }

    public void printTailToHead(){
        Node temp = tail;
        if(Objects.equals(temp.lead, null)){
            System.out.println("List is empty");
            return;
        }
        while(temp != null && !Objects.equals(temp.lead, null)){
            System.out.println(temp.lead.toString());
            temp = temp.prev;
        }
        temp = head;
        while(temp != null && !Objects.equals(temp.lead, null)){
            System.out.println(temp.lead.toString());
            temp = temp.next;
        }
    }

    public void removeLead(String companyName, String jobTitle){
        Node temp = head;
        if(Objects.equals(temp.lead, null)){
            System.out.println("List is empty");
            return;
        }
        while(temp != null){
            if(Objects.equals(temp.lead.getCompanyName(), companyName) && Objects.equals(temp.lead.getJobTitle(), jobTitle)){
                temp.lead = null;
                temp = head;
                return;
            }
            temp = temp.next;
        }
        temp = tail;
        while(temp != null) {
            if (Objects.equals(temp.lead.getCompanyName(), companyName) && Objects.equals(temp.lead.getJobTitle(), jobTitle)) {
                temp.lead = null;
                temp = tail;
                return;
            }
            temp = temp.prev;
        }
    }

}
