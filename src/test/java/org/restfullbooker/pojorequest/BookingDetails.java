package org.restfullbooker.pojorequest;

public class BookingDetails {
    private String firstname;
    private String lastname;
    private int totalprice;

    private boolean depositpaid;

    private BookingDates bookingdates;

    private String additionalneeds;

    public BookingDetails() {

    }

    public BookingDetails(String firstname){
        this.firstname=firstname;
    }

    public BookingDetails(String firstName, String lastName, int totalPrice, boolean depositePaid, BookingDates bookingDates, String additionalneeds) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.totalprice = totalPrice;
        this.depositpaid = depositePaid;
        this.bookingdates = bookingDates;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstName(){
       return  this.firstname;
    }

    public String  getLastName(){
        return this.lastname;
    }

    public int getTotalPrice(){
       return this.totalprice;
    }

    public boolean getDepositePaid(){
        return this.depositpaid;
    }

    public boolean isDepositePaid() {
        return depositpaid;
    }

    public BookingDates getBookingDates() {
        return bookingdates;
    }

    public String getAddtionalneeds() {
        return additionalneeds;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastname;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalprice = totalprice;
    }

    public void setDepositePaid(boolean depositePaid) {
        this.depositpaid = depositpaid;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingdates = bookingdates;
    }

    public void setAddtionalneeds(String addtionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", totalPrice=" + totalprice +
                ", depositePaid=" + depositpaid +
                ", bookingDates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }

    public class BookingDates {

        private String checkin;
        private String checkout;


        public BookingDates(String checkIn, String checkOut) {
            this.checkin = checkIn;
            this.checkout = checkOut;
        }

        public String getCheckIn() {
            return checkin;
        }

        public void setCheckIn(String checkIn) {
            this.checkin = checkin;
        }

        public String getCheckOut() {
            return checkout;
        }

        public void setCheckOut(String checkOut) {
            this.checkout = checkOut;
        }


        @Override
        public String toString() {
            return "BookingDates{" +
                    "checkIn='" + checkin + '\'' +
                    ", checkOut='" + checkout + '\'' +
                    '}';
        }

    }




    }










