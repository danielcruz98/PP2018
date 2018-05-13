/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Produtos;

import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class RepositorioProduto {

    public static final RepositorioProduto INSTANCE = new RepositorioProduto();
    private HashMap lista;

    private RepositorioProduto() {

        lista = new HashMap<String, Produto>();

    }

    public void registarProduto(String codigoBarras, Produto produto) throws ProdutoJaExiste {
        if (verificarExistencia(codigoBarras)) {

            lista.put(codigoBarras, produto);
        }
    }

    public boolean verificarProduto(String codigoBarras) {
        return lista.containsKey(codigoBarras);
    }

    public Produto obterProduto(String codigoBarras) {
        return (Produto) lista.get(codigoBarras);
    }

    public HashMap getLista() {
        return lista;
    }

    public void setLista(HashMap lista) {
        this.lista = lista;
    }

    public boolean verificarExistencia(String codigoBarras) throws ProdutoJaExiste {

        if (verificarProduto(codigoBarras)) {

            throw new ProdutoJaExiste("O Produto já existe nesta loja");

        }

        return true;
    }

    ;
        public class ProdutoJaExiste extends Exception {

        public ProdutoJaExiste() {
        }

        public ProdutoJaExiste(String message) {
            super(message);
        }
    }

}
