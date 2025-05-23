package com.example.eventhello.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    private Long id;
    private Date bookingdate;
    private String status;

   @ManyToOne
    private User user;

   @ManyToOne
   private Event event;

}
