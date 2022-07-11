package com.coshmex.store.service;

import com.coshmex.store.mappper.ProductMapper;
import com.coshmex.store.model.Item;
import com.coshmex.store.model.Producto;
import com.coshmex.store.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{
    static private Logger logger = LogManager.getLogger(ProductoServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    public int guarda(Item producto) {
    ProductMapper mapper = new ProductMapper();
    productRepository.save(mapper.fromItem(producto));
    return 0;
    }

    @Override
    public int guardaLista(List <Item> saveList) {
        for (int i = 0; i < saveList.size(); i++) {
            guarda(saveList.get(i));
        }
        return 0;
    }

    @Override
    public Producto getProducto(String clave) {
        ProductMapper mapper = new ProductMapper();
        Producto producto =   productRepository.findByClave(clave);
        Item item = mapper.fromProducto(producto);
        logger.info(" CLAVE {} descripcion {}" , clave, item.getDescripcion());
        return producto;
    }


    //FeingClient




}

