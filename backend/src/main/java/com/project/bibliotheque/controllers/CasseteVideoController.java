package com.project.bibliotheque.controllers;

import com.project.bibliotheque.entities.CasseteVideo;
import com.project.bibliotheque.services.CasseteVideoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cassetesvideos")
public class CasseteVideoController {
    private final CasseteVideoService casseteVideoService;

    public CasseteVideoController(CasseteVideoService casseteVideoService) {
        this.casseteVideoService = casseteVideoService;
    }
    @GetMapping
    public List<CasseteVideo> getAllCasseteVideos(){
        return casseteVideoService.getAllCasseteVideo();
    }
    @GetMapping("/{id}")
    public CasseteVideo getCasseteVideoById(@PathVariable Long id){
        return casseteVideoService.getCasseteVideoById(id);
    }
    @PostMapping
    public CasseteVideo addCasseteVideo(@RequestBody CasseteVideo casseteVideo){
        return casseteVideoService.addCasseteVideo(casseteVideo);
    }
    @PutMapping("/{id}")
    public CasseteVideo updateCasseteVideo(@PathVariable Long id,@RequestBody CasseteVideo casseteVideo){
        casseteVideo.setIdDocument(id);
        return casseteVideoService.updateCasseteVideo(casseteVideo);
    }
    @DeleteMapping("/{id}")
    public void deleteCasseteVideoById(@PathVariable Long id){
        casseteVideoService.deleteCasseteVideoById(id);
    }
}
