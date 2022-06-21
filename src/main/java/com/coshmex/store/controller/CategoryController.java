package com.coshmex.store.controller;

import com.coshmex.store.model.Item;
import com.coshmex.store.service.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CategoryController {

    static private Logger logger = LogManager.getLogger(CategoryController.class);

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = {"/rest/getCategoria"}, method = {RequestMethod.GET})
    @GetMapping("/rest/getCategoria")
    @ResponseBody

    public Item getCategoria(HttpServletRequest request,
                             @RequestParam(value = "categoria", defaultValue = "", required = false) String categoria) {


            logger.info("   CATEGORIA {}  " , categoria);

            return categoryService.getCategoria(categoria);

        }
}
