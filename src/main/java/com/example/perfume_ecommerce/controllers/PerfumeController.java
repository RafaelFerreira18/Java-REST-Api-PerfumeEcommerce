package com.example.perfume_ecommerce.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.perfume_ecommerce.models.Perfume;
import com.example.perfume_ecommerce.repositories.PerfumeRepository;
import com.example.perfume_ecommerce.services.PerfumeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("perfume")
public class PerfumeController {
    @Autowired
    private final PerfumeService perfumeService;

    public PerfumeController(PerfumeService perfumeService, PerfumeRepository perfumeRepository){
        this.perfumeService = perfumeService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Perfume>> searchAll(){
        return ResponseEntity.ok(perfumeService.searchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfume> searchById(@PathVariable Long id){
        Perfume returnedPerfume = perfumeService.searchById(id);
        return ResponseEntity.ok(returnedPerfume);
    }

    @PostMapping
	public ResponseEntity<Perfume> insert(@RequestBody Perfume perfume) {
		var perfumeCreated = perfumeService.insert(perfume);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(perfumeCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(perfumeCreated);
    }

    @PutMapping("/{id}")
	public ResponseEntity<Perfume> update(@PathVariable Long id, @RequestBody Perfume perfume) {
		perfumeService.update(id, perfume);
		return ResponseEntity.ok(perfume);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        perfumeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filterCategory")
    public List<Perfume> getPerfumesByCategory(@RequestParam String category) {
        return perfumeService.getPerfumesByCategory(category);
    }
    
    @GetMapping("/filterPrice")
    public List<Perfume> getPerfumesByPriceRange(@RequestParam String priceRange) {
        Double minPrice = 0.0;
        Double maxPrice = 0.0;

        switch (priceRange) {
            case "350-600":
                minPrice = 350.0;
                maxPrice = 600.0;
                break;
            case "600-800":
                minPrice = 600.0;
                maxPrice = 800.0;
                break;
            case "800-1500":
                minPrice = 800.0;
                maxPrice = 1500.0;
                break;
            default:
                throw new IllegalArgumentException("Faixa de preço inválida: " + priceRange);
        }

        return perfumeService.getPerfumesByPriceRange(minPrice, maxPrice);
    }
}
