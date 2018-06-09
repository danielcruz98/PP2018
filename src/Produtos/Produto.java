/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import java.io.Serializable;

/**
 *
 * @author daniel
 */
public class Produto implements Serializable {

    private String codigoBarras, nomeProduto, marca, referencia;

    /**
     *
     *
     */
    public Produto() {
    }

    /**
     *
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
     *
     *
     * @return
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     *
     *
     * @param codigoBarras
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    /**
     *
     *
     * @return
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     *
     *
     * @param nomeProduto
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     *
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     *
     * @return
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     *
     *
     * @param referencia
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
