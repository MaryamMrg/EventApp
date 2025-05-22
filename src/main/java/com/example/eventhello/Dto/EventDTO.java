package com.example.eventhello.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EventDTO {

    private Long id;
    private String title;
    private String description;
    private Date date;



}
