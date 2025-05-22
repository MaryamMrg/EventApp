package com.example.eventhello.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class Event {
@Id
private Long id ;

private String title ;
private String description ;

private double price ;
private Date date;



}
