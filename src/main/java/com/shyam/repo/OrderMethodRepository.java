package com.shyam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyam.model.OrderMethod;

public interface OrderMethodRepository extends JpaRepository<OrderMethod, Integer> {

}
