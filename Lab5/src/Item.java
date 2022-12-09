/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 5
*/

public abstract class Item {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    Item(){
        title = null;
    }

    Item(String t){
        title = t;
    }

    public abstract String getListing();

    public String toString(){
        return title;
    }
}
