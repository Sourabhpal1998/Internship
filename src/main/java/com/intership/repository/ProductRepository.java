package com.intership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intership.entity.ProductDetails;

@Repository
public interface ProductRepository extends JpaRepository<ProductDetails, Long> {

}
