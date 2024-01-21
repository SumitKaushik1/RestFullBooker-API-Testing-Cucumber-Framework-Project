package org.restfullbooker.pojorequest;

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