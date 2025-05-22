package com.example.eventhello.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Id @GeneratedValue(strategy = GenerationType.AUTO)
private Long id ;

private String title ;
private String description ;

private double price ;
private Date date;



}
