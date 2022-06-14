package com.coshmex.store.controller;



import java.io.IOException;
import java.util.*;

import javax.management.remote.rmi.RMIServer;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.coshmex.store.mappper.ProductMapper;
import com.coshmex.store.mappper.ProductUniversalMapper;
import com.coshmex.store.model.Item;
import com.coshmex.store.model.ProductoShopify;
import com.coshmex.store.service.ProductoShopifyLayoutWriterService;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;


@Controller
public class ArticuloController {
  private static final Logger logger =  LoggerFactory.getLogger(ArticuloController.class);

  private static final double IVA = 1.16D;

  Map<Integer, List<String>> pdtData = new HashMap<>();

  ProductMapper pMapper = new ProductMapper();

  @Autowired
  ProductoShopifyLayoutWriterService productShopifyService;

  @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})

  @RequestMapping(value = {"/rest/articulos"}, method = {RequestMethod.GET})
  @GetMapping("/rest/articulos")
  @ResponseBody
  public List<Item> getproduct(HttpServletRequest request, @RequestParam(value = "marca", defaultValue = "", required = false) String marca, @RequestParam(value = "clave", defaultValue = "", required = false) String clave, @RequestParam(value = "grupo", defaultValue = "", required = false) String grupo, @RequestParam(value = "codigo", defaultValue = "", required = false) String codigo) {
    logger.info("Start  Searching Product with codigo {} and brand {}  ", codigo, marca);
    String url = "https://www.grupocva.com/catalogo_clientes_xml/lista_precios.xml?cliente=17658";
    StringBuffer sb = new StringBuffer(url);
    sb.append("&marca=").append(marca);
    sb.append("&clave=").append(clave);
    sb.append("&codigo=").append(codigo);
    sb.append("&grupo=").append(grupo);
    sb.append("&promos=").append("1");
    sb.append("&porcentaje=").append("10");

   String url2 = "https://www.grupocva.com/catalogo_clientes_xml/lista_precios.xml?cliente=17658&marca=&grupo=PORTATILES&clave=&codigo=&porcentaje=10&promos=1";
   List<Item> list = null;


  DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
  defaultClientConfig.getClasses().add(MappingJackson2XmlView.class);
  com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
  Client client = Client.create(config);    logger.info(" sb {}", url2 );
  WebResource webresource = client.resource(url2);
  list = webresource.get(new GenericType<List<Item>>(){});

//    productShopifyService.writeCSV();
    logger.info(" Tamaño {} ",list.size());

    return list;
  }
}
