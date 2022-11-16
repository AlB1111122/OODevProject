import java.util.ArrayList;

public abstract class Person{
    private String ID;
    private String name;
    private int phoneNumber;
    private ArrayList<Complaint> complaints = new ArrayList<Complaint>();

    Person(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getID(){
        return ID;
    }

    void setID(String ID){
        this.ID = ID;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Complaint> getComplaints() {
        return complaints;
    }

    public void addComplaint(Complaint complaint){
        complaints.add(complaint);
    }

    public boolean checkComplaints(){
        if(complaints.size() > 3){
            return true;
        }else{
            return false;
        }
    }

    public void makeComplaint(Person complainer, Person complaintAbout, String description){
        Complaint comp = new Complaint(complainer, complaintAbout, description);
        complaints.add(comp);
    }
}












