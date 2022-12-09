/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 5
*/

public class Book extends Item{

    private int isbn_number;
    private String author;

    Book(){
        this.isbn_number = 0000000000000;
        this.author = "";
        this.setTitle(null);
    }

    Book(int isbn, String author, String title){
        this.isbn_number = isbn;
        this.author = author;
        this.setTitle(title);
    }

    public int getIsbn_number(){
        return this.isbn_number;
    }

    public void setIsbn_number(int isbn_number){
        this.isbn_number = isbn_number;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getListing() {
        return "Book Title - " + this.getTitle() + "\nAuthor - " + this.author + "\nISBN Number - " + this.isbn_number;
    }
}
