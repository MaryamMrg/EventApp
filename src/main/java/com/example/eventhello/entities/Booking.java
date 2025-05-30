package com.example.eventhello.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity

public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookingdate;
    private String status;

    public Booking() {
    }

    public Booking(Long id, String bookingdate, String status) {
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

    //   @ManyToOne
//    private User user;

//   @ManyToOne
//   private Event event;

}
