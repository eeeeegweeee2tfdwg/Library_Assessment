//Declare this is as a package file
package stage1_Cameron;

//Define Loan class
public class Loan {
    private final int loanId;
    private final int memberId;
    private final String isbn;
    public String dueDate;

    //Define Loan function
    public Loan(int loanId, int memberId, String isbn, String dueDate) {
        this.loanId = loanId;
        this.memberId = memberId;
        this.isbn = isbn;
        this.dueDate = dueDate;
    }

    //Define getLoadId function
    public int getLoanId() {
        return this.loanId;
    }

    //Define getMemberId function
    public int getMemberId() {
        return this.memberId;
    }

    //Define getIsbn function
    public String getIsbn() {
        return this.isbn;
    }

    //Define getDueDate function
    public String getDueDate() {
        return this.dueDate;
    }
}