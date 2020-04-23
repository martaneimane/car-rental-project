package com.example.repository;

import com.example.model.CarReturn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarReturnRepository extends JpaRepository<CarReturn, Long> {
}
