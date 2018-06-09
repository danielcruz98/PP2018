/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import Users.Loja;
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
     *
     *
     */
    public ProdutoLoja() {
    }

    /**
     *
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
     *
     *
     * @return
     */
    public Loja getLoja() {
        return loja;
    }

    /**
     *
     *
     * @param loja
     */
    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    /**
     *
     *
     * @return
     */
    public double getPreco() {
        return preco;
    }

    /**
     *
     *
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     *
     *
     * @return
     */
    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    /**
     *
     *
     * @param disponibilidade
     */
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    /**
     *
     *
     * @return
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     *
     *
     * @param produto
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
