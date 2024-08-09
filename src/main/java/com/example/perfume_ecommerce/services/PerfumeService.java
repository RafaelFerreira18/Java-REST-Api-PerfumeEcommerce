package com.example.perfume_ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.perfume_ecommerce.models.Perfume;
import com.example.perfume_ecommerce.repositories.PerfumeRepository;

@Service
public class PerfumeService {
    @Autowired
    private PerfumeRepository perfumeRepository;

    public Iterable<Perfume> searchAll(){
        return perfumeRepository.findAll();
    }

    public Perfume searchById(Long id){
        Optional<Perfume> perfume = perfumeRepository.findById(id);
        return perfume.get();
    }

    public void update(Long id, Perfume perfume){
        Optional<Perfume> perfumeId = perfumeRepository.findById(id);
        if(perfumeId.isPresent()){
            perfumeRepository.save(perfume);
        }
    }

    public void delete(Long id){
        perfumeRepository.deleteById(id);
    }

    public Perfume insert(Perfume perfume) {
        if(perfumeRepository.existsByPerfumeName(perfume.getPerfumeName())){
			throw new IllegalArgumentException("This perfume already exists!");
		}
        return this.perfumeRepository.save(perfume);
    }
}
