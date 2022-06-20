package com.coshmex.store.repository;

import com.coshmex.store.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ProductRepository, String> {

    @Query(value = "SELECT u FROM Producto u WHERE u.categoria = ?1")
    Producto findByCategoria (String categoria);

}

