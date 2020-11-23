package io.shangan23.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.shangan23.api.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
