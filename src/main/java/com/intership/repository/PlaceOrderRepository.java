package com.intership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intership.entity.PlaceOrder;

@Repository
public interface PlaceOrderRepository extends JpaRepository<PlaceOrder, Long> {

}
