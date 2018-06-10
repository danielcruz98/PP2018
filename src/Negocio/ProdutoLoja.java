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
public class ProdutoLoja extends RepositorioProduto implements Serializable {

    private double preco;
    private boolean disponibilidade;
    private Produto produto;
    private Loja loja;

    /**
     *construtor ProdutoLoja
     *
     */
    public ProdutoLoja() {
    }

    /**
     *construtor ProdutoLoja
     *
     * @param preco
     * @param disponibilidade
     * @param produto
     * @param loja
     */
    public ProdutoLoja(double preco, boolean disponibilidade, Produto produto, Loja loja) {
        this.preco = preco;
        this.disponibilidade = disponibilidade;
        this.produto = produto;
        this.loja = loja;
    }

    /**
     *get loja
     *
     * @return
     */
    public Loja getLoja() {
        return loja;
    }

    /**
     *set loja
     *
     * @param loja
     */
    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    /**
     *get preco
     *
     * @return
     */
    public double getPreco() {
        return preco;
    }

    /**
     *set preco
     *
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     *get disponibilidade
     *
     * @return
     */
    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    /**
     *set disponibilidade
     *
     * @param disponibilidade
     */
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    /**
     *get produto
     *
     * @return
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     *set produto
     *
     * @param produto
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
