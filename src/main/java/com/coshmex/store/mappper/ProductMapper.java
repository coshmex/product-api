package com.coshmex.store.mappper;


import com.coshmex.store.model.Item;
import com.coshmex.store.model.ProductoShopify;

public class ProductMapper {
  public ProductoShopify fromProduct(Item item) {
    ProductoShopify pShop = new ProductoShopify(item.getDescripcion(), item.getDescripcion(), getBodyHTML(item.getDescripcion()), "cva", item.getGrupo(), "", "true", item.getDescripcion(), "", "", "", "", "", item.getCodigo_fabricante(), "", "", item.getDisponibleCD(), "deny", "manual", getPrecioPublico(item), "", getEnviable(item), "true", "", item.getImagen(), "1", "", "false", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "kg", "", item.getPrecio().toString());
    return pShop;
  }
  
  public String getBodyHTML(String data) {
    return "<meta charset=\"utf-8\"><span>" + data + "</span>";
  }
  
  public String getPrecioPublico(Item i) {
    Double d = i.getPrecio();
    Double ganancia = Double.valueOf(1.1D);
    switch (i.getGrupo()) {
      case "AC":
        ganancia = Double.valueOf(1.2D);
        break;
    } 
    Double publico = Double.valueOf(d.doubleValue() * ganancia.doubleValue());
    return publico.toString();
  }
  
  public String getEnviable(Item i) {
    Boolean enviable = Boolean.valueOf(!i.getGrupo().equals("SOFTWARE"));
    return enviable.toString();
  }
}
