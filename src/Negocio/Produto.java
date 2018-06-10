/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;

/**
 *
 * @author daniel
 */
public class Produto implements Serializable {

    private String codigoBarras, nomeProduto, marca, referencia;

    /**
     *construtor Produto
     *
     */
    public Produto() {
    }

    /**
     *construtor Produto
     *
     * @param codigoBarras
     * @param nomeProduto
     * @param marca
     * @param referencia
     */
    public Produto(String codigoBarras, String nomeProduto, String marca, String referencia) {

        this.codigoBarras = codigoBarras;
        this.nomeProduto = nomeProduto;
        this.marca = marca;
        this.referencia = referencia;

    }

    /**
     *get codigo de barras
     *
     * @return
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     *set codigo de barras
     *
     * @param codigoBarras
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    /**
     *get nome do produto
     *
     * @return
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     *set nome do produto
     *
     * @param nomeProduto
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     *get marca
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *set marca
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *get referencia
     *
     * @return
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     *set referencia
     *
     * @param referencia
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
