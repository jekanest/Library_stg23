public class Availability extends Books{

    private String BookAvail = "Lost, GivenToSomeone, UnderRepair, Ordered, PlaceId";

    public Availability() {
    }

    public Availability(String bookAvail) {
        BookAvail = bookAvail;
    }

    public String getBookAvail() {
        return BookAvail;
    }

    public void setBookAvail(String bookAvail) {
        BookAvail = bookAvail;
    }
}
