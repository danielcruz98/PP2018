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
public class DadosProdutoLoja {
    private double preco;
    private boolean disponibilidade;

    public DadosProdutoLoja(double preco, boolean disponibilidade) {
        this.preco = preco;
        this.disponibilidade = disponibilidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
    
}
