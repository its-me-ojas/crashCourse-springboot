package com.ojas.crashCourse.repository;

import com.ojas.crashCourse.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
