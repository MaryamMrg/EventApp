package com.example.eventhello.Controllers;

import com.example.eventhello.Dto.BookingDTO;
import com.example.eventhello.Services.BookingS;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingC {
    private final BookingS bookingS;

    public BookingC(BookingS bookingS) {
        this.bookingS = bookingS;
    }

    @PostMapping
    public BookingDTO booking(@RequestBody BookingDTO bookingDTO) {
        return bookingS.createBooking(bookingDTO);

    }

    @GetMapping
    public List<BookingDTO> getbookings() {
        return bookingS.getAllBookings();
    }


}
