package com.coshmex.store.repository;

import com.coshmex.store.model.ProductoSyscom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductoSyscom, String> {

}
