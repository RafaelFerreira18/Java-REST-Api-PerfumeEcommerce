package com.example.perfume_ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.perfume_ecommerce.models.Perfume;

@Repository
public interface PerfumeRepository extends CrudRepository<Perfume, Long>{
    boolean existsByPerfumeName(String perfumeName);
    List<Perfume> findByCategory(String category);
    List<Perfume> findByPriceBetween(Double minPrice, Double maxPrice);
}