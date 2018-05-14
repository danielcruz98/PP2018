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
public class RepositorioProdutoLoja extends RepositorioProduto {
    HashMap listaLoja;

    public RepositorioProdutoLoja(Loja loja, ProdutoLoja dados) {
        listaLoja.put(loja, dados);
    };
    

    
}
