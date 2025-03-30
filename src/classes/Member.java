//Declare this is as a package file
package classes;

//Define Member class
public class Member {
    private final int memberId;
    private final String name;
    private String contact;
    //Define Member function
    public Member(int memberId, String name, String contact){
        this.memberId = memberId;
        this.name = name;
        this.contact = contact;
    }
    //Define getMemberId function
    public int getMemberId(){
        return this.memberId;
    }
    //Define getName function
    public String getName(){
        return this.name;
    }
    //Define getContact function
    public String getContact() {
        return this.contact;
    }
    //Define displayInfo function
    public void displayInfo(){
        contact = getContact();
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
    }
}