//Declare this is as a package file
package classes;

//Define Book class
public class Book {
    private final String isbn;
    private final String title;
    private final String author;

    // Define Book function
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    //Define getIsbn function
    public String getIsbn() {
        return this.isbn;
    }
    //Define getTitle function
    public String getTitle() {
        return this.title;
    }
    //Define getAuthor function
    public String getAuthor() {
        return this.author;
    }
    //Define displayInfo function
    public void displayInfo() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}