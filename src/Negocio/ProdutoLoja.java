/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class ProdutoLoja extends RepositorioProduto{
    private Produto produto;
    private double preco;
    private boolean disponibilidade;
    private ArrayList<Produto> listaProduto;
    
    public ProdutoLoja(Produto produto, double preco, boolean disponibilidade) {
        this.produto = produto;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
        listaProduto = new ArrayList<Produto>();
    }
    
    public void associarProdutoLoja(Produto produto){
        
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
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
    
    
}
