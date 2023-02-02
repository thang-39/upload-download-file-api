package com.example.dogApi.repository;

import com.example.dogApi.entity.DogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<DogPost, Long> {
}
