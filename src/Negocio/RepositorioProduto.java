/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class RepositorioProduto {

    HashMap lista;

    public RepositorioProduto() {
        lista = new HashMap<String, Produto>();
    }

    public void registarProduto(String codigoBarras, Produto produto) {
        lista.put(codigoBarras, produto);
    }

    public boolean verificarProduto(String codigoBarras) {
        return lista.containsKey(codigoBarras);
    }
    
     public Produto obterProduto(String codigoBarras) {
        return  (Produto) lista.get(codigoBarras);
    }

    public HashMap getLista() {
        return lista;
    }

    public void setLista(HashMap lista) {
        this.lista = lista;
    }
     
     

}
