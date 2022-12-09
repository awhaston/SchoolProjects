/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 5
*/

public class Periodical extends Item{
    private int issueNum;

    Periodical(){
        issueNum = 000;
    }

    Periodical(int issueNum, String title){
        this.issueNum = issueNum;
        this.setTitle(title);
    }

    public int getIssueNum(){
        return issueNum;
    }

    public void setIssueNum(int issueNum){
        this.issueNum = issueNum;
    }

    public String getListing(){
        return "Periodical Title - " + this.getTitle() + "\nIssue # - " + issueNum;
    }
}
