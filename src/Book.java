public class Book {
    long isbn;
    String title;
    String author;

    public Book(long isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public long getIsbn(){
        return this.isbn;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public void displayInfo(){
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}   