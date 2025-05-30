package com.example.eventhello.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class BookingDTO {


    private Long id;
    private String bookingdate;

    private String status;

    public BookingDTO() {
    }

    public BookingDTO(Long id, String bookingdate, String status) {
        this.id = id;
        this.bookingdate = bookingdate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
