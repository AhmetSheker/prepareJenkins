package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HerOkuPojo {
    protected String firstname;
    protected String lastname;
    protected Integer totalprice;
    protected Boolean depositpaid;
    protected BookingDatePojo bookingdate;
    protected String additionalneeds;

    public HerOkuPojo(String firstname, String lastname, Integer totalprice, Boolean depositpaid, BookingDatePojo bookingdate, String additionalneeds){
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdate = bookingdate;
        this.additionalneeds = additionalneeds;
    }

    public HerOkuPojo(){}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDatePojo getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(BookingDatePojo bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "HerOkuPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdate=" + bookingdate +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
