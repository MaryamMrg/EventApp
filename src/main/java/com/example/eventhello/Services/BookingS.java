package com.example.eventhello.Services;

import com.example.eventhello.Dto.BookingDTO;
import com.example.eventhello.Mapper.BookingMapper;
import com.example.eventhello.Mapper.EventMapper;
import com.example.eventhello.Repositories.BookingRepository;
import com.example.eventhello.Repositories.EventRepository;
import com.example.eventhello.Repositories.UserRepository;
import com.example.eventhello.entities.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingS {

  private final BookingMapper bookingMapper;
  private final BookingRepository bookingRepository;
  private final EventRepository eventRepository;
  private final UserRepository userRepository;


  public BookingS(BookingMapper bookingMapper, BookingRepository bookingRepository, EventRepository eventRepository, UserRepository userRepository) {
    this.bookingMapper = bookingMapper;
    this.bookingRepository = bookingRepository;
      this.eventRepository = eventRepository;
      this.userRepository = userRepository;
  }

//  public BookingDTO createBooking(BookingDTO bookingDTO) {
//      Booking booking = bookingMapper.toEntity(bookingDTO);
//      Booking savedBooking = bookingRepository.save(booking);
//      return bookingMapper.toDto(savedBooking);
//  }
public BookingDTO createBooking(BookingDTO bookingDTO) {
    System.out.println("=== RECEIVED BOOKING DTO ===");
    System.out.println("Booking ID: " + bookingDTO.getId());
    System.out.println("Booking Date: " + bookingDTO.getBookingdate());
    System.out.println("Status: " + bookingDTO.getStatus());

    Booking booking = bookingMapper.toEntity(bookingDTO);

    System.out.println("=== MAPPED BOOKING ENTITY ===");
    System.out.println("ID: " + booking.getId());
    System.out.println("Booking Date: " + booking.getBookingdate());
    System.out.println("Status: " + booking.getStatus());

    Booking savedBooking = bookingRepository.save(booking);

    System.out.println("=== SAVED BOOKING ===");
    System.out.println("ID: " + savedBooking.getId());
    System.out.println("Booking Date: " + savedBooking.getBookingdate());
    System.out.println("Status: " + savedBooking.getStatus());

    return bookingMapper.toDto(savedBooking);
}
  public List<BookingDTO> getAllBookings() {
      List<Booking> bookings = bookingRepository.findAll();
      return bookingMapper.toDtos(bookings);
  }

}
