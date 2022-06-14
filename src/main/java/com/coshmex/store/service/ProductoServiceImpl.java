package com.coshmex.store.service;

import com.coshmex.store.mappper.ProductMapper;
import com.coshmex.store.model.Item;
import com.coshmex.store.model.ProductoSyscom;
import com.coshmex.store.repository.ProductRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductoServiceImpl implements ProductoService{



    @Autowired
    ProductRepository productRepository;

    @Override
    public int guarda(Item producto) {
    ProductMapper mapper = new ProductMapper();
    productRepository.save(mapper.fromItem(producto));
    return 0;

    }

}
