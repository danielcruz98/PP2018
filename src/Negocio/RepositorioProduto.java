/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class RepositorioProduto implements Serializable {

    HashMap lista;

    /**
     *construtor RepositorioProduto
     *
     */
    public RepositorioProduto() {
        lista = new HashMap<String, Produto>();
    }

    /**
     *faz o registo do produto
     *
     * @param produto
     * @throws Negocio.RepositorioProduto.ProdutoDuplicadoException
     */
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

    /**
     *retorna o produto
     *
     * @param codigoBarras
     * @return
     * @throws Negocio.RepositorioProduto.ProdutoNaoExistenteException
     */
    public Produto getProduto(String codigoBarras) throws ProdutoNaoExistenteException {
        if (lista.containsKey(codigoBarras)) {
            return (Produto) lista.get(codigoBarras);
        } else {
            throw new ProdutoNaoExistenteException("O produto  já existe na lista");
        }
    }

    /**
     *verifica se o produto existe no hash map
     *
     * @param codigoBarras
     * @return
     */
    public boolean verificarProduto(String codigoBarras) {
        return lista.containsKey(codigoBarras);
    }

    /**
     *retorna uma ArrayList com todos os produtos do hash map
     *
     * @return
     */
    public ArrayList<Produto> todos() {
        return new ArrayList<>(lista.values());
    }

    /**
     *retorna o tamanho do hash map
     *
     * @return
     */
    public int size() {
        return lista.size();
    }

    /**
     *Exception
     *
     */
    public class ProdutoDuplicadoException extends Exception {

        /**
         *
         *
         */
        public ProdutoDuplicadoException() {
        }

        /**
         *Exception
         *
         * @param message
         */
        public ProdutoDuplicadoException(String message) {
            super(message);
        }
    }

    /**
     *Exception
     *
     */
    public class ProdutoNaoExistenteException extends Exception {

        /**
         *Exception
         *
         */
        public ProdutoNaoExistenteException() {
        }

        /**
         *Exception
         *
         * @param message
         */
        public ProdutoNaoExistenteException(String message) {
            super(message);
        }
    }
}
