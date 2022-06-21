package com.coshmex.store.service;

import com.coshmex.store.mappper.ProductMapper;
import com.coshmex.store.model.Item;
import com.coshmex.store.model.Producto;
import com.coshmex.store.repository.CategoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    static private Logger logger = LogManager.getLogger(CategoryServiceImpl.class);

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Item getCategory(String categoria) {
          ProductMapper mapper = new ProductMapper();
          Producto productos = (Producto) categoryRepository.findByCategoria(categoria);
            Item items = mapper.fromProducto(productos);
            logger.info(" CATEGORIA {} " , categoria, items.getDescripcion());
            return items;
    }

    @Override
    public List<Item> getCategories() {
        return null;
    }

    @Override
    public List<Producto> getCategories(String categoria) {
        return categoryRepository.findByCategoria(categoria);
    }


}
