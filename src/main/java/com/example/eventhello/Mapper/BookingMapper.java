package com.example.eventhello.Mapper;


import com.example.eventhello.Dto.BookingDTO;
import com.example.eventhello.entities.Booking;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking toEntity(BookingDTO dto);
    BookingDTO toDto(Booking booking);
    List<BookingDTO> toDtos(List<Booking> bookings);


}
