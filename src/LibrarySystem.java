import java.util.ArrayList;
import java.util.Scanner;
public class LibrarySystem {
    ArrayList<Book> books;
    ArrayList<Member> members;
    ArrayList<Loan> loans;
    Scanner scanner;
    
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
            System.out.println("3. Display Book");
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
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
        System.exit(choice);
    }

    public void addBook(){
        System.out.println("Enter ISBN: ");
        long isbn = scanner.nextLong();
        
    }

    public void searchBook(){
        
    }

    public void displayBook(){
        
    }

    public void removeBook(){
        
    }
    
    public void addMember(){
        
    }

    public void searchMember(){
        
    }

    public void displayMember(){
        
    }

    public void removeMember(){
        
    }

    public void loanBook(){
        
    }

    public void returnBook(){
        
    }

    public void displayMembersLoans(){
        
    }
}