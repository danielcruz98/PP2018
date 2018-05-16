/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;


/**
 *
 * @author daniel
 */
public class Produto {
    private String codigoBarras,nomeProduto, marca, referencia;
        
    public Produto(){}
    
    public Produto(String codigoBarras, String nomeProduto, String marca, String referencia) {
        
        this.codigoBarras = codigoBarras;
        this.nomeProduto = nomeProduto;
        this.marca = marca;
        this.referencia = referencia;
        
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
