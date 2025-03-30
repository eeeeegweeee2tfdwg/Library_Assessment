// Import the required modules
import classes.Book;
import classes.Loan;
import classes.Member;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//Define the MelLibrary class
public class MelLibrary {
    ArrayList<Book> books;
    ArrayList<Member> members;
    ArrayList<Loan> loans;
    Scanner scanner;
    int nextLoanId = 1;
    
    //Define MelLibrary function
    public MelLibrary() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        // Add books
        Book _newBook = new Book("1", "Test Book", "Luke");
        books.add(_newBook);
        Book _newBook1 = new Book("2", "Another Test Book", "Tim");
        books.add(_newBook1);
        Book _newBook2 = new Book("3", "Again Another Test Book", "Mike");
        books.add(_newBook2);

        Member _newMember = new Member(1, "Simon", "00");
        members.add(_newMember);
        Member _newMember1 = new Member(2, "Bob", "01");
        members.add(_newMember1);
        Member _newMember2 = new Member(3, "Barry", "02");
        members.add(_newMember2);

        //Clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();


        //Menu display
        do {
            System.out.println("╭┈┈ MelLibrary System ┈┈╮");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display Books");
            System.out.println("4. Remove Book");
            System.out.println("5. Add Member");
            System.out.println("6. Search Member");
            System.out.println("7. Display Members");
            System.out.println("8. Remove Member");
            System.out.println("9. Loan Book");
            System.out.println("10. Return Book");
            System.out.println("11. Show Member Loans");
            System.out.println("0. Exit");
            System.out.println("╰┈┈                   ┈┈╯");
            System.out.print("<<< Enter your choice >>> : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> searchBook();
                case 3 -> displayBook();
                case 4 -> removeBook();
                case 5 -> addMember();
                case 6 -> searchMember();
                case 7 -> displayMember();
                case 8 -> removeMember();
                case 9 -> loanBook();
                case 10 -> returnBook();
                case 11 -> displayMemberLoans();
                case 0 -> {
                    //Clear the screen and exit
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Exiting...");
                }
                default -> {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Invalid choice.");
                }
            }
        } while (choice != 0);
        scanner.close();
        System.exit(choice);
    }
    //Add a book to the database
    public void addBook() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Add Book --");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        Book newBook = new Book(isbn, title, author);
        books.add(newBook);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book added successfully!");
    }

    // Search for a book
    public void searchBook() {
        int choice;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Search Book --");
        System.out.println("Search by: ");
        System.out.println("1. ISBN");
        System.out.println("2. Title ");
        System.out.println("3. Author ");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> searchIsbn();
            case 2 -> searchTitle();
            case 3 -> searchAuthor();
            default -> {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Invalid choice.");
            }
            }
    }

    //Search book via ISBN
    public void searchIsbn() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book with ISBN " + isbn + " not found.");
    }
    //Search book by Title
    public void searchTitle() {
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book with title '" + title + "' not found.");
    }

    //Search book by Author
    public void searchAuthor() {
        System.out.print("Enter Author: ");
        String Author = scanner.nextLine();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(Author)) {
                book.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book with author '" + Author + "' not found.");
    }

    //Display all books
    public void displayBook() {
        if (books.isEmpty()) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("No books in the library.");
            return;
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            book.displayInfo();
            System.out.println("--------------------");
        }
    }

    //Remove a book from the database
    public void removeBook() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Remove Book --");
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();
        Iterator<Book> iterator = books.iterator();
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

    //Add a new member to the database
    public void addMember() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Add Member --");
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Information: ");
        String contact = scanner.nextLine();
        Member newMember = new Member(memberId, name, contact);
        members.add(newMember);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Member added successfully!");
    }

    //Search for a member
    public void searchMember() {
        int choice;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Search Member --");
        System.out.println("Search by: ");
        System.out.println("1. Member ID");
        System.out.println("2. Name ");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        switch (choice) {
            case 1 -> searchID();
            case 2 -> searchName();
            default -> {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Invalid choice.");
            }
        }
    }

    //Search for a member with their ID
    public void searchID() {
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                member.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Member with ID " + memberId + " not found.");
    }

    //Search for a member by their name
    public void searchName() {
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                member.displayInfo();
                return;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Member with name '" + name + "' not found.");
    }

    //Display all members
    public void displayMember() {
        if (members.isEmpty()) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("No members in the library.");
            return;
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\nLibrary Members:");
        for (Member member : members) {
            member.displayInfo();
            System.out.println("--------------------");
        }
    }

    //Remove a member from the database
    public void removeMember() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Remove Member --");
        System.out.print("Enter Member ID of the member to remove: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        Iterator<Member> iterator = members.iterator();
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

    // Loan a book
    public void loanBook() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Loan Book --");
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Due Date: ");
        String dueDate = scanner.nextLine();
        Member member = null;
        for (Member m : members) {
            if (m.getMemberId() == memberId) {
                member = m;
                break;
            }
        }
        Book book = null;
        for (Book b : books) {
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
        for (Loan loan : loans) {
            if (loan.getIsbn().equals(isbn) && loan.getDueDate() != null) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Book with ISBN " + isbn + " is already loaned.");
                return;
            }
        }
        Loan newLoan = new Loan(nextLoanId++, memberId, isbn, dueDate);
        loans.add(newLoan);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Book loaned successfully!");
    }

    //Return a book
    public void returnBook() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Return Book --");
        System.out.print("Enter Book ISBN to return: ");
        String isbn = scanner.nextLine();
        Iterator<Loan> iterator = loans.iterator();
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

    //Display all the loans from a member
    public void displayMemberLoans() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-- Loans --");
        System.out.print("Enter Member ID to display loaned books: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        boolean memberFound = false;
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                memberFound = true;
                break;
            }
        }
        if (!memberFound) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Member with ID " + memberId + " not found.");
            return;
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Books loaned by Member ID " + memberId + ":");
        boolean loansFound = false;
        for (Loan loan : loans) {
            if (loan.getMemberId() == memberId && loan.getDueDate() != null) {
                loansFound = true;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                for (Book book : books) {
                    if (book.getIsbn().equals(loan.getIsbn())) {
                        System.out.println("Loan ID: " + loan.getLoanId() + "  Title: " + book.getTitle() + "  Author: " + book.getAuthor() + ", ISBN: " + loan.getIsbn() + ", Due Date: "
                                + loan.getDueDate());
                        break;
                    }
                }
            }
        }
        if (!loansFound) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("No books currently loaned by this member.");
        }
    }
    //Run the script
    public static void main(String[] ignored) {
        MelLibrary library = new MelLibrary();
        library.run();
    }
}