package org.restfullbooker.pojoresponse;

import org.restfullbooker.pojorequest.BookingDetails;

public class BookingDetailsResponse {

    int bookingid;
    BookingDetails booking;
    //the class field must be similar to the respone field name other wise ti will make problem
    public int getBookingid() {
        return bookingid;
    }

    public BookingDetails getBookingDetails() {
        return booking;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public void setBookingDetails(BookingDetails booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingDetailsResponse{" +
                "bookingid=" + bookingid +
                ", bookingDetails=" + booking +
                '}';
    }
}
