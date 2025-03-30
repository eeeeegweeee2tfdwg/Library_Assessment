package tests;

import classes.Book;
import classes.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import classes.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MelLibraryTest {
    ArrayList<Book> TestBooks;
    ArrayList<Member> TestMembers;
    ArrayList<Loan> TestLoans;
    Scanner TestScanner;
    int TestNextLoanId = 1;

    @BeforeEach
    void setUp() {
        TestBooks = new ArrayList<>();
        TestMembers = new ArrayList<>();
        TestLoans = new ArrayList<>();
        Book _newBook = new Book("1", "Test Book", "Luke");
        TestBooks.add(_newBook);
        Book _newBook1 = new Book("2", "Another Test Book", "Tim");
        TestBooks.add(_newBook1);
        Book _newBook2 = new Book("3", "Again Another Test Book", "Mike");
        TestBooks.add(_newBook2);

        Member _newMember = new Member(1, "Simon", "00");
        TestMembers.add(_newMember);
        Member _newMember1 = new Member(2, "Bob", "01");
        TestMembers.add(_newMember1);
        Member _newMember2 = new Member(3, "Barry", "02");
        TestMembers.add(_newMember2);
        Loan newLoan = new Loan(TestNextLoanId++, 1, "1", "Now");
        TestLoans.add(newLoan);
    }


    @Test
    void addBook() {
        String input = "978-0321765723\nEffective Java\nJoshua Bloch\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);

        System.out.println("-- Add Book --");
        System.out.print("Enter ISBN: ");
        String isbn = TestScanner.nextLine();
        System.out.print("Enter Title: ");
        String title = TestScanner.nextLine();
        System.out.print("Enter Author: ");
        String author = TestScanner.nextLine();
        Book newBook = new Book(isbn, title, author);
        TestBooks.add(newBook);
        System.out.println("Book added successfully!");
        System.out.println(isbn + "\n" + title + "\n" + author);

        // Assert that the book was added
        assertEquals(1, TestBooks.size());
        assertEquals("978-0321765723", TestBooks.getFirst().getIsbn());
        assertEquals("Effective Java", TestBooks.getFirst().getTitle());
        assertEquals("Joshua Bloch", TestBooks.getFirst().getAuthor());

        TestScanner.close(); // Close the scanner
    }

    @Test
    void searchIsbn() {
        String input = "1";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("Enter ISBN: ");
        String isbn = TestScanner.nextLine();
        for (Book book : TestBooks) {
            if (book.getIsbn().equals(isbn)) {
                book.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    @Test
    void searchIsbnNotFound() {
        String input = "13";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("Enter ISBN: ");
        String isbn = TestScanner.nextLine();
        for (Book book : TestBooks) {
            if (book.getIsbn().equals(isbn)) {
                book.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    @Test
    void searchTitle() {
        String input = "Test Book";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("Enter Title: ");
        String title = TestScanner.nextLine();
        for (Book book : TestBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book with title '" + title + "' not found.");
    }

    @Test
    void searchAuthor() {
        String input = "Luke";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("Enter Author: ");
        String Author = TestScanner.nextLine();
        for (Book book : TestBooks) {
            if (book.getAuthor().equalsIgnoreCase(Author)) {
                book.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book with author '" + Author + "' not found.");
    }

    @Test
    void searchAuthorNotFound() {
        String input = "Tommy";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("Enter Author: ");
        String Author = TestScanner.nextLine();
        for (Book book : TestBooks) {
            if (book.getAuthor().equalsIgnoreCase(Author)) {
                book.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book with author '" + Author + "' not found.");
    }

    @Test
    void removeBook() {
        String input = "1";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Remove Book --");
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = TestScanner.nextLine();
        Iterator<Book> iterator = TestBooks.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Book with ISBN " + isbn + " removed.");
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    @Test
    void removeBookNotFound() {
        String input = "30";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Remove Book --");
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = TestScanner.nextLine();
        Iterator<Book> iterator = TestBooks.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Book with ISBN " + isbn + " removed.");
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    @Test
    void addMember() {
        String input = "1\nCameron\n0000000";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Add Member --");
        System.out.print("Enter Member ID: ");
        int memberId = TestScanner.nextInt();
        TestScanner.nextLine();
        System.out.print("Enter Member Name: ");
        String name = TestScanner.nextLine();
        System.out.print("Enter Contact Information: ");
        String contact = TestScanner.nextLine();
        Member newMember = new Member(memberId, name, contact);
        TestMembers.add(newMember);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Member added successfully!");
    }

    @Test
    void searchID() {
        String input = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("Enter Member ID: ");
        int memberId = TestScanner.nextInt();
        TestScanner.nextLine();
        for (Member member : TestMembers) {
            if (member.getMemberId() == memberId) {
                member.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Member with ID " + memberId + " not found.");
    }

    @Test
    void searchIDNotFound() {
        String input = "10\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("Enter Member ID: ");
        int memberId = TestScanner.nextInt();
        TestScanner.nextLine();
        for (Member member : TestMembers) {
            if (member.getMemberId() == memberId) {
                member.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Member with ID " + memberId + " not found.");
    }

    @Test
    void searchName() {
        String input = "Bob\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("Enter Member Name: ");
        String name = TestScanner.nextLine();
        for (Member member : TestMembers) {
            if (member.getName().equalsIgnoreCase(name)) {
                member.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Member with name '" + name + "' not found.");
    }

    @Test
    void searchNameNotFound() {
        String input = "Cameron\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("Enter Member Name: ");
        String name = TestScanner.nextLine();
        for (Member member : TestMembers) {
            if (member.getName().equalsIgnoreCase(name)) {
                member.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Member with name '" + name + "' not found.");
    }

    @Test
    void removeMember() {
        String input = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Remove Member --");
        System.out.print("Enter Member ID of the member to remove: ");
        int memberId = TestScanner.nextInt();
        TestScanner.nextLine();
        Iterator<Member> iterator = TestMembers.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getMemberId() == memberId) {
                iterator.remove();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Member with ID " + memberId + " removed.");
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Member with ID " + memberId + " not found.");
    }

    @Test
    void removeMemberNotFound() {
        String input = "10\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Remove Member --");
        System.out.print("Enter Member ID of the member to remove: ");
        int memberId = TestScanner.nextInt();
        TestScanner.nextLine();
        Iterator<Member> iterator = TestMembers.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getMemberId() == memberId) {
                iterator.remove();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Member with ID " + memberId + " removed.");
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Member with ID " + memberId + " not found.");
    }

    @Test
    void loanBook() {
        String input = "1\n1\nNow\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Loan Book --");
        System.out.print("Enter Member ID: ");
        int memberId = TestScanner.nextInt();
        TestScanner.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = TestScanner.nextLine();
        System.out.print("Enter Due Date: ");
        String dueDate = TestScanner.nextLine();
        Member member = null;
        for (Member m : TestMembers) {
            if (m.getMemberId() == memberId) {
                member = m;
                break;
            }
        }
        Book book = null;
        for (Book b : TestBooks) {
            if (b.getIsbn().equals(isbn)) {
                book = b;
                break;
            }
        }
        if (member == null) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Member with ID " + memberId + " not found.");
            return;
        }
        if (book == null) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
        for (Loan loan : TestLoans) {
            if (loan.getIsbn().equals(isbn) && loan.getDueDate() != null) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Book with ISBN " + isbn + " is already loaned.");
                return;
            }
        }
        Loan newLoan = new Loan(TestNextLoanId++, memberId, isbn, dueDate);
        TestLoans.add(newLoan);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book loaned successfully!");
    }

    @Test
    void loanBookNotFoundOne() {
        String input = "10\n1\nNow\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Loan Book --");
        System.out.print("Enter Member ID: ");
        int memberId = TestScanner.nextInt();
        TestScanner.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = TestScanner.nextLine();
        System.out.print("Enter Due Date: ");
        String dueDate = TestScanner.nextLine();
        Member member = null;
        for (Member m : TestMembers) {
            if (m.getMemberId() == memberId) {
                member = m;
                break;
            }
        }
        Book book = null;
        for (Book b : TestBooks) {
            if (b.getIsbn().equals(isbn)) {
                book = b;
                break;
            }
        }
        if (member == null) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Member with ID " + memberId + " not found.");
            return;
        }
        if (book == null) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
        for (Loan loan : TestLoans) {
            if (loan.getIsbn().equals(isbn) && loan.getDueDate() != null) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Book with ISBN " + isbn + " is already loaned.");
                return;
            }
        }
        Loan newLoan = new Loan(TestNextLoanId++, memberId, isbn, dueDate);
        TestLoans.add(newLoan);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book loaned successfully!");
    }

    @Test
    void loanBookNotFoundTwo() {
        String input = "1\n10\nNow\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Loan Book --");
        System.out.print("Enter Member ID: ");
        int memberId = TestScanner.nextInt();
        TestScanner.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = TestScanner.nextLine();
        System.out.print("Enter Due Date: ");
        String dueDate = TestScanner.nextLine();
        Member member = null;
        for (Member m : TestMembers) {
            if (m.getMemberId() == memberId) {
                member = m;
                break;
            }
        }
        Book book = null;
        for (Book b : TestBooks) {
            if (b.getIsbn().equals(isbn)) {
                book = b;
                break;
            }
        }
        if (member == null) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Member with ID " + memberId + " not found.");
            return;
        }
        if (book == null) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
        for (Loan loan : TestLoans) {
            if (loan.getIsbn().equals(isbn) && loan.getDueDate() != null) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Book with ISBN " + isbn + " is already loaned.");
                return;
            }
        }
        Loan newLoan = new Loan(TestNextLoanId++, memberId, isbn, dueDate);
        TestLoans.add(newLoan);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book loaned successfully!");
    }

    @Test
    void returnBook() {
        String input = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Return Book --");
        System.out.print("Enter Book ISBN to return: ");
        String isbn = TestScanner.nextLine();
        Iterator<Loan> iterator = TestLoans.iterator();
        boolean bookReturned = false;
        while (iterator.hasNext()) {
            Loan loan = iterator.next();
            if (loan.getIsbn().equals(isbn) && loan.getDueDate() != null) {
                loan.dueDate = null;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Book with ISBN " + isbn + " returned successfully.");
                bookReturned = true;
                break;
            }
        }
        if (!bookReturned) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Book with ISBN " + isbn + " is not currently loaned or does not exist.");
        }
    }

    @Test
    void returnBookNotFound() {
        String input = "2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        TestScanner = new Scanner(in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Return Book --");
        System.out.print("Enter Book ISBN to return: ");
        String isbn = TestScanner.nextLine();
        Iterator<Loan> iterator = TestLoans.iterator();
        boolean bookReturned = false;
        while (iterator.hasNext()) {
            Loan loan = iterator.next();
            if (loan.getIsbn().equals(isbn) && loan.getDueDate() != null) {
                loan.dueDate = null;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Book with ISBN " + isbn + " returned successfully.");
                bookReturned = true;
                break;
            }
        }
        if (!bookReturned) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Book with ISBN " + isbn + " is not currently loaned or does not exist.");
        }
    }

}