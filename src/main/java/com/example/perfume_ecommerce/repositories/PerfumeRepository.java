package com.example.perfume_ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.perfume_ecommerce.models.Perfume;

@Repository
public interface PerfumeRepository extends CrudRepository<Perfume, Long>{
}