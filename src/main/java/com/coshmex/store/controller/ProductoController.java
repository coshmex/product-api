package com.coshmex.store.controller;

import com.coshmex.store.model.Item;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@RestController
public class ProductoController {
    static private Logger logger = LogManager.getLogger(ProductoController.class);


    @GetMapping("/rest/portatiles")
    public List<Item> getRecentMovie() {

        logger.info("Start  Searching Product with model {} and brand {}  " );
        String url = "https://www.grupocva.com/catalogo_clientes_xml/lista_precios.xml?cliente=17658&marca=&grupo=PORTATILES&clave=&codigo=&porcentaje=10&promos=1";
        System.out.println("URL:\n" + url);

        List<Item> list = (List<Item>) Client.create().resource(url).get((GenericType)new Object());
        List<Item> listaFinal = new ArrayList<>();

        Iterator<Item> it = list.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            Double pfinal = Double.valueOf(item.getPrecio().doubleValue() * 1.16D);
            item.setPrecio(pfinal);
            listaFinal.add(item);
        }
        return listaFinal;


    }

}
