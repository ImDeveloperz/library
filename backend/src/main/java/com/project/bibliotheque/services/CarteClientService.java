package com.project.bibliotheque.services;

import com.project.bibliotheque.entities.CarteClient;
import com.project.bibliotheque.repositories.CartClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteClientService {
    private final CartClientRepository carteClientRepository;
    @Autowired
    public CarteClientService(CartClientRepository carteClientRepository) {
        this.carteClientRepository = carteClientRepository;
    }
    public CarteClient addCarteClient(CarteClient carteClient){
       return carteClientRepository.save(carteClient);
    }
    public CarteClient updateCarteClient(CarteClient carteClient){
        return carteClientRepository.save(carteClient);
    }
    public CarteClient getCarteClientById(Long id){
        return carteClientRepository.findById(id).orElse(null);
    }
    //get all
    public List<CarteClient> getAllCarteClients(){
        return carteClientRepository.findAll();
    }
    //delete
    public void deleteCarteClientById(Long id){
        carteClientRepository.deleteById(id);
    }
}
