package com.project.bibliotheque.controllers;

import com.project.bibliotheque.entities.Reservation;
import com.project.bibliotheque.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }
    @GetMapping("/{id}")
    public Reservation getReservationById(Long id){
        return reservationService.getReservationById(id);
    }
    @PostMapping
    public Reservation addReservation(Reservation reservation){
        return reservationService.addReservation(reservation);
    }
    @PutMapping("/{id}")
    public Reservation updateReservation(Long id, Reservation reservation){
        reservation.setIdTransaction(id);
        return reservationService.updateReservation(reservation);
    }
    @DeleteMapping("/{id}")
    public void deleteReservationById(Long id){
        reservationService.deleteReservationById(id);
    }

}
