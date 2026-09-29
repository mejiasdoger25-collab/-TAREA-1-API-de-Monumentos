package com.salesianos.dam.tareamonumentos;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/monument")
public class MonumentController {

    private final MonumentRepository monumentRepository;
    //private final MonumentService monumentService;

    @GetMapping
    public ResponseEntity<List<Monument>> getAllMonuments() {
        List<Monument> result = monumentRepository.findAll();
        if (result.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monument> getMonumentById(@PathVariable Long id) {
        return ResponseEntity.of(monumentRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Monument> addMonument(@RequestBody Monument monument){
        if (StringUtils.hasText(monument.getMonumentName())){
            return ResponseEntity.status(201).body(monumentRepository.save(monument));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monument> updateMonument(@PathVariable Long id, @RequestBody Monument monument){
        return monumentRepository.findById(id).map(m -> {
            m.setMonumentName(monument.getMonumentName());
            m.setMonumentDescription(monument.getMonumentDescription());
            m.setCityName(monument.getCityName());
            m.setCountryCode(monument.getCountryCode());
            m.setCountryName(monument.getCountryName());
            m.setImageURL(monument.getImageURL());
            m.setLatitude(monument.getLatitude());
            m.setLength(monument.getLength());
            return ResponseEntity.ok(monumentRepository.save(m));
        })
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonument(@PathVariable Long id){
        monumentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
