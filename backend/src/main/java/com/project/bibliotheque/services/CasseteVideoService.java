package com.project.bibliotheque.services;

import com.project.bibliotheque.entities.CasseteVideo;
import com.project.bibliotheque.repositories.CasseteVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasseteVideoService {
    private final CasseteVideoRepository casseteVideoRepository;

    @Autowired
    public CasseteVideoService(CasseteVideoRepository casseteVideoRepository) {
        this.casseteVideoRepository = casseteVideoRepository;
    }

    public CasseteVideo getCasseteVideoById(Long id){
        return  casseteVideoRepository.findById(id).orElse(null);
    }
    public List<CasseteVideo> getAllCasseteVideo(){
        return casseteVideoRepository.findAll();
    }
    public CasseteVideo addCasseteVideo(CasseteVideo casseteVideo){
        return casseteVideoRepository.save(casseteVideo);
    }
    public CasseteVideo updateCasseteVideo(CasseteVideo casseteVideo){
        return casseteVideoRepository.save(casseteVideo);
    }
    public void deleteCasseteVideoById(Long id){
        casseteVideoRepository.deleteById(id);
    }

}
