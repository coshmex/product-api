package com.coshmex.store.service;

import com.coshmex.store.model.Item;
import com.coshmex.store.model.Producto;

import java.util.List;

public interface CategoryService {

    Item getCategory (String categoria);

    List<Item> getCategories();

    List<Producto> getCategories(String categoria);
}
