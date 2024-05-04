package com.project.bibliotheque.services;


import com.project.bibliotheque.entities.Reservation;
import com.project.bibliotheque.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public Reservation addReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public Reservation updateReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public Reservation getReservationById(Long id){
        return reservationRepository.findById(id).orElse(null);
    }
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    public void deleteReservationById(Long id){
        reservationRepository.deleteById(id);
    }

}
