package classes;

public class Loan {
    private final int loanId;
    private final int memberId;
    private final String isbn;
    public String dueDate;

    public Loan(int loanId, int memberId, String isbn, String dueDate){
        this.loanId = loanId;
        this.memberId = memberId;
        this.isbn = isbn;
        this.dueDate = dueDate;
    }

    public int getLoanId(){
        return this.loanId;
    }
    
    public int getMemberId(){
        return this.memberId;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public String getDueDate(){
        return this.dueDate;
    }
}