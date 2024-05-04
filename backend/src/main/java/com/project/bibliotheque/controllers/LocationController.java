package com.project.bibliotheque.controllers;


import com.project.bibliotheque.entities.Location;
import com.project.bibliotheque.services.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @GetMapping
    public List<Location> getAllLocations(){
        return locationService.getAllLocations();
    }
    @GetMapping("/{id}")
    public Location getLocationById(Long id){
        return locationService.getLocationById(id);
    }
    @PostMapping
    public Location addLocation(Location location) {
        return locationService.addLocation(location);
    }
    @PutMapping("/{id}")
    public Location updateLocation(Long id, Location location){
        location.setIdTransaction(id);
        return locationService.updateLocation(location);
    }
    @DeleteMapping("/{id}")
    public void deleteLocationById(Long id){
        locationService.deleteLocationById(id);
    }
}
