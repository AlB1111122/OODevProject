public class Table{
    private int tableID;
    private int seats;
    //private boolean movable;

    Table(int seats, int tableID){
        this.tableID = tableID;
        this.seats = seats;
        //this.movable = movable;
    }

    public int getTableID(){
        return tableID;
    }

    public int getSeats(){
        return seats;
    }

    //public boolean getMovable(){
    //    return movable;
    //}

    public String toString(){
        //String mov = "cannot be moved";
        //if(movable){
        //    mov = "can be moved";
        //}
        return String.format("Table number: %d, Number of seats %d",tableID,seats);
    }
}
