package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HerOkuResponsePojo {
    private Integer bookingid;
    private HerOkuPojo booking;

    public HerOkuResponsePojo(Integer bookingid, HerOkuPojo booking){
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public HerOkuResponsePojo(){}

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public HerOkuPojo getBooking() {
        return booking;
    }

    public void setBooking(HerOkuPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "HerOkuResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
