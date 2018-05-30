/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Produtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class RepositorioProduto implements Serializable{
    public static final RepositorioProduto INSTANCE = new RepositorioProduto();
    HashMap lista;

    public RepositorioProduto() {
        lista = new HashMap<String, Produto>();
    }

    public void registarProduto(Produto produto) throws ProdutoDuplicadoException {
        if (produto == null) {
            throw new NullPointerException("O parâmetro 'produto' não pode ser um valor nulo");
        }

        if (!lista.containsKey(produto.getCodigoBarras())) {
            lista.put(produto.getCodigoBarras(), produto);
        } else {
            throw new ProdutoDuplicadoException(String.format("O produto  já existe na coleção"));
        }
    }

    public Produto getProduto(String codigoBarras) throws ProdutoNaoExistenteException {
        if (lista.containsKey(codigoBarras)) {
            return (Produto) lista.get(codigoBarras);
        } else {
            throw new ProdutoNaoExistenteException("O produto  já existe na lista");
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

    public ArrayList<Produto> todos() {
        return new ArrayList<>(lista.values());
    }

    public int size() {
        return lista.size();
    }

    public class ProdutoDuplicadoException extends Exception {

        public ProdutoDuplicadoException() {
        }

        public ProdutoDuplicadoException(String message) {
            super(message);
        }
    }

    public class ProdutoNaoExistenteException extends Exception {

        public ProdutoNaoExistenteException() {
        }

        public ProdutoNaoExistenteException(String message) {
            super(message);
        }
    }
}
