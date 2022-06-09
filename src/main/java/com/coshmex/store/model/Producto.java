/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coshmex.web.base.model;


import javax.persistence.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author vladd
 */
@Entity
@Table(name = "Producto")
public class Producto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idProducto")
    private Integer idProducto;
    
   
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @Column(name = "marca")
    private String marca;
    @Column(name = "existencia")
    private Double existencia;
    @Column(name = "stock_min")
    private Integer stockMin;
    @Column(name = "stock_max")
    private Integer stockMax;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    
    @Column(name = "estatus")
    private String estatus;
    


    @JoinColumn(name = "idUnidad", referencedColumnName = "idUnidad")
    @ManyToOne
    private Unidad idUnidad;
    
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne
    private Categoria idCategoria;



    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String descripcion, String clave) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.clave = clave;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        Integer oldIdProducto = this.idProducto;
        this.idProducto = idProducto;
        changeSupport.firePropertyChange("idProducto", oldIdProducto, idProducto);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        Double oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        changeSupport.firePropertyChange("marca", oldMarca, marca);
    }

    public Double getExistencia() {
        return existencia;
    }

    public void setExistencia(Double existencia) {
        Double oldExistencia = this.existencia;
        this.existencia = existencia;
        changeSupport.firePropertyChange("existencia", oldExistencia, existencia);
    }

    public Integer getStockMin() {
        return stockMin;
    }

    public void setStockMin(Integer stockMin) {
        Integer oldStockMin = this.stockMin;
        this.stockMin = stockMin;
        changeSupport.firePropertyChange("stockMin", oldStockMin, stockMin);
    }

    public Integer getStockMax() {
        return stockMax;
    }

    public void setStockMax(Integer stockMax) {
        Integer oldStockMax = this.stockMax;
        this.stockMax = stockMax;
        changeSupport.firePropertyChange("stockMax", oldStockMax, stockMax);
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        String oldClave = this.clave;
        this.clave = clave;
        changeSupport.firePropertyChange("clave", oldClave, clave);
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        String oldEstatus = this.estatus;
        this.estatus = estatus;
        changeSupport.firePropertyChange("estatus", oldEstatus, estatus);
    }



    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
       Categoria oldIdCategoria = this.idCategoria;
        this.idCategoria = idCategoria;
        changeSupport.firePropertyChange("idCategoria", oldIdCategoria, idCategoria);
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coshmex.agroquimicos.desktop.entity.Producto[ idProducto=" + idProducto + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
