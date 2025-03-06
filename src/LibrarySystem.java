import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class LibrarySystem {
    ArrayList<Book> books;
    ArrayList<Member> members;
    ArrayList<Loan> loans;
    Scanner scanner;
    int nextLoanId = 1; 
    
    public LibrarySystem(){
        books = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run(){
        int choice;

        do { 
            System.out.println("\n--- MelLibrary System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display Books");
            System.out.println("4. Remove Book");
            System.out.println("5. Add Member");
            System.out.println("6. Search Member");
            System.out.println("7. Display Member");
            System.out.println("8. Remove Member");
            System.out.println("9. Loan Book");
            System.out.println("10. Return Book");
            System.out.println("11. Show Member Loans");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
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
                case 0 -> System.out.println("Exiting...");
                default -> System.out.print("Invalid choice.");
            }
        } while (choice != 0);
        scanner.close();
        System.exit(choice);
    }

    public void addBook(){
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        Book newBook = new Book(isbn, title, author);
        books.add(newBook);
        System.out.print("Book added successfully!");
    }

    public void searchBook(){
            int choice;
            System.out.println("Search by: ");
            System.out.println("1. ISBN");
            System.out.println("2. Title ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> searchIsbn();
                case 2 -> searchTitle();
                default -> System.out.print("Invalid choice.");
            }
    }

    public void searchIsbn(){
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                    book.displayInfo();
                    return;
            }
        }
        System.out.print("Book with ISBN " + isbn + " not found.");
    }

    public void searchTitle(){
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) { 
                    book.displayInfo();
                    return;
                }
            }
        System.out.print("Book with title '" + title + "' not found.");
    }

    public void displayBook(){
        if (books.isEmpty()){
            System.out.print("No books in the library.");
            return;
        }
        System.out.print("\nLibrary Books:");
        for (Book book : books) {
            book.displayInfo();
            System.out.println("--------------------");
        }
    }

    public void removeBook(){
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                System.out.print("Book with ISBN " + isbn + " removed.");
                return;
            }
        }
        System.out.print("Book with ISBN " + isbn + " not found.");
    }
    
    public void addMember(){
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Information: ");
        String contact = scanner.nextLine();
        Member newMember = new Member(memberId, name, contact);
        members.add(newMember);
        System.out.print("Member added successfully!");
    }

    public void searchMember(){
            int choice;
            
            System.out.println("Search by: ");
            System.out.println("1. Member ID");
            System.out.println("2. Name ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> searchID();
                case 2 -> searchName();
                default -> System.out.println("Invalid choice.");
            }
    }

    public void searchID(){
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                member.displayInfo();
                return;
            }
        }
        System.out.print("Member with ID " + memberId + " not found.");
    }

    public void searchName(){
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) { 
                member.displayInfo();
                return;
            }
        }
        System.out.print("Member with name '" + name + "' not found.");
    }

    public void displayMember(){
        if (members.isEmpty()) {
            System.out.print("No members in the library.");
            return;
        }
        System.out.print("\nLibrary Members:");
        for (Member member : members) {
            member.displayInfo();
            System.out.println("--------------------");
        }
    }

    public void removeMember(){
        System.out.print("Enter Member ID of the member to remove: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        Iterator<Member> iterator = members.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getMemberId() == memberId) {
                iterator.remove(); 
                System.out.print("Member with ID " + memberId + " removed.");
                return; 
            }
        }
        System.out.print("Member with ID " + memberId + " not found.");
    }

    public void loanBook(){
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
            System.out.print("Member with ID " + memberId + " not found.");
            return;
        }
        if (book == null) {
            System.out.print("Book with ISBN " + isbn + " not found.");
            return;
        }
        for (Loan loan : loans) {
            if (loan.getIsbn().equals(isbn) && loan.getDueDate() != null) { 
                System.out.print("Book with ISBN " + isbn + " is already loaned.");
                return;
            }
        }
        Loan newLoan = new Loan(nextLoanId++, memberId, isbn, dueDate);
        loans.add(newLoan);
        System.out.print("Book loaned successfully!");
    }

    public void returnBook(){
        System.out.print("Enter Book ISBN to return: ");
        String isbn = scanner.nextLine();
        Iterator<Loan> iterator = loans.iterator();
        boolean bookReturned = false;
        while (iterator.hasNext()) {
            Loan loan = iterator.next();
            if (loan.getIsbn().equals(isbn) && loan.getDueDate() != null) { 
                loan.dueDate = null; 
                System.out.print("Book with ISBN " + isbn + " returned successfully.");
                bookReturned = true;
                break; 
            }
        }
        if (!bookReturned) {
            System.out.print("Book with ISBN " + isbn + " is not currently loaned or does not exist.");
        }
    }

    public void displayMemberLoans(){
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
            System.out.print("Member with ID " + memberId + " not found.");
            return;
        }
        System.out.print("Books loaned by Member ID " + memberId + ":");
        boolean loansFound = false;
        for (Loan loan : loans) {
            if (loan.getMemberId() == memberId && loan.getDueDate() != null) {
                loansFound = true;
                for(Book book : books){
                    if (book.getIsbn().equals(loan.getIsbn())){
                        System.out.print("  Title: " + book.getTitle() + ", ISBN: " + loan.getIsbn() + ", Due Date: " + loan.getDueDate());
                        break;
                    }
                }
            }
        }
        if (!loansFound) {
            System.out.print("  No books currently loaned by this member.");
        }
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.run();
    }
}