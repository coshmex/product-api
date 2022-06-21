package com.coshmex.store.service;

import com.coshmex.store.model.Item;

import java.util.List;

public interface ProductoService{
    int guarda(Item producto);

    int guardaLista(List<Item> saveList);

    Item getProducto (String clave);


}


