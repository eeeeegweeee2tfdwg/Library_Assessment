public class Member {
    int memberId;
    String name;
    String contact;

    public Member(int memberId, String name, String contact){
        this.memberId = memberId;
        this.name = name;
        this.contact = contact;
    }

    public int getMemberId(){
        return this.memberId;
    }

    public String getName(){
        return this.name;
    }
    
    public String getContact(){
        return this.contact;
    }

    public void displayInfo(){
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
    }
}