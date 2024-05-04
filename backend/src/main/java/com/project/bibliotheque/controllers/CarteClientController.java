package com.project.bibliotheque.controllers;

import com.project.bibliotheque.entities.CarteClient;
import com.project.bibliotheque.services.CarteClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carteClient")
public class CarteClientController {
    private final CarteClientService carteClientService;

    public CarteClientController(CarteClientService carteClientService) {
        this.carteClientService = carteClientService;
    }
    @GetMapping
    public List<CarteClient> getCarteClient(){
        return carteClientService.getAllCarteClients();
    }
    @GetMapping("/{id}")
    public CarteClient getCarteClientById(Long id){
        return carteClientService.getCarteClientById(id);
    }
    @PostMapping
    public CarteClient addCarteClient(CarteClient carteClient){
        return carteClientService.addCarteClient(carteClient);
    }
    @PutMapping("/{id}")
    public CarteClient updateCarteClient(Long id, CarteClient carteClient){
        carteClient.setIdCarteClient(id);
        return carteClientService.updateCarteClient(carteClient);
    }
    @DeleteMapping("/{id}")
    public void deleteCarteClientById(Long id){
        carteClientService.deleteCarteClientById(id);
    }
}
