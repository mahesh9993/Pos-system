package com.sprinbootcourse.Pos.repo;

import com.sprinbootcourse.Pos.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    boolean existsByCustomerIdEquals (int customerId);
}
