/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Produtos;

import Negocio.Utilizadores.Loja;

/**
 *
 * @author daniel
 */
public class ProdutoLoja {

    RepositorioProduto repositorioProduto = RepositorioProduto.INSTANCE;
    private double preco;
    private boolean disponibilidade;
    private Produto produto;
    private Loja loja;

    public ProdutoLoja(double preco, boolean disponibilidade, Produto produto, Loja loja) {

        this.preco = preco;
        this.disponibilidade = disponibilidade;
        this.produto = produto;
        this.loja = loja;

    }

    public ProdutoLoja(double preco, boolean disponibilidade, String codigoBarras, Loja loja) {

        this.preco = preco;
        this.disponibilidade = disponibilidade;
        this.produto = repositorioProduto.obterProduto(codigoBarras);
        this.loja = loja;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

}
