package com.example.eventhello.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BookingDTO {


    private Long bookingId;
    private Date date;
    private String status;

}
