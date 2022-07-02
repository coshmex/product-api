package com.coshmex.store.service;

import com.coshmex.store.model.Item;
import com.coshmex.store.model.Producto;

import java.util.List;

public interface ProductoService{
    int guarda(Item producto);

    int guardaLista(List<Item> saveList);

    Producto getProducto (String clave);


}


