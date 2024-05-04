package com.project.bibliotheque.services;

import com.project.bibliotheque.entities.Location;
import com.project.bibliotheque.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService  {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    public Location addLocation(Location location){
        return locationRepository.save(location);
    }
    public Location updateLocation(Location location){
        return locationRepository.save(location);
    }
    public Location getLocationById(Long id){
        return locationRepository.findById(id).orElse(null);
    }
    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }
    public void deleteLocationById(Long id){
        locationRepository.deleteById(id);
    }
}
