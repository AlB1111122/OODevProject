public class Complaint{
    private Person complainer;
    private Person complaintAbout;
    private String description;

    Complaint(Person complainer, Person complaintAbout, String description){
        this.complainer = complainer;
        this.complaintAbout = complaintAbout;
        this.description = description;
    }

    public Person getComplainer() {
        return complainer;
    }

    public Person getComplaintAbout() {
        return complaintAbout;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return String.format("Compliant made by: %s, about: %s, Complaint: %s",complainer,complaintAbout,description);
    }
}
