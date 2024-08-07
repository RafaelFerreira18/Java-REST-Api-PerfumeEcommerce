package com.example.perfume_ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.perfume_ecommerce.models.User;

public interface UserRepository extends CrudRepository<User, Long> {}