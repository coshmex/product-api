package com.coshmex.store.controller;

import com.coshmex.store.model.Item;
import com.coshmex.store.model.Producto;
import com.coshmex.store.service.ProductoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ProductoController {
    static private Logger logger = LogManager.getLogger(ProductoController.class);
    @Autowired
    ProductoService productoService;
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    @RequestMapping(value = {"/rest/getProduct"}, method = {RequestMethod.GET})
    @GetMapping("/rest/getProduct")
    @ResponseBody

    public Producto getProducto(HttpServletRequest request,
                                @RequestParam(value = "clave", defaultValue = "", required = false) String clave) {

        logger.info("   CLAVE {}  " , clave);

        return productoService.getProducto(clave);

    }
    //POST
}
