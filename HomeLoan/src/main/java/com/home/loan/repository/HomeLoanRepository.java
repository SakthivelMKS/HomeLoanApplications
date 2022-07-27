package com.home.loan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home.loan.model.HomeLoan;

@Repository
public interface HomeLoanRepository extends CrudRepository<HomeLoan, Long> {

}
