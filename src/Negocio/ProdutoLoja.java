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
public class ProdutoLoja extends RepositorioProduto{
    
    private double preco;
    private boolean disponibilidade;
    private Produto produto;

    
    public ProdutoLoja(double preco, boolean disponibilidade,Produto produto) {
        
        this.preco = preco;
        this.disponibilidade = disponibilidade;
        this.produto = produto;

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
    
    
}
