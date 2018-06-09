/*To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class RepositorioProdutoLoja implements Serializable {

    private ArrayList<ProdutoLoja> repositorio;
    private static final RepositorioProdutoLoja INSTANCE = new RepositorioProdutoLoja();

    /**
     *
     *
     */
    public RepositorioProdutoLoja() {
        repositorio = new ArrayList();
    }

    /**
     *
     * @param dados
     * @throws Produtos.RepositorioProdutoLoja.ProdutoJaExisteNaLojaException
     */
    public void addProdutoLoja(ProdutoLoja dados) throws ProdutoJaExisteNaLojaException {

        verificarExistencia(dados);
        repositorio.add(dados);

    }

    /**
     *
     *
     * @param i
     * @return
     */
    public ProdutoLoja getProdutoLoja(int i) {
        return repositorio.get(i);
    }

    //fazer 3 metodos diferentes de forma a procurar cada um sozoinho
    /**
     *
     *
     * @param s
     * @return
     */
    public ArrayList<ProdutoLoja> procurarNome(String s) {
        ArrayList<ProdutoLoja> temp = new ArrayList<>();

        for (ProdutoLoja p : lista()) {
            if (p.getProduto().getNomeProduto().contains(s)) {
                temp.add(p);
            }
        }

        return temp;
    }

    /**
     *
     * @param s
     * @return
     */
    public ArrayList<ProdutoLoja> procurarMarca(String s) {
        ArrayList<ProdutoLoja> temp = new ArrayList<>();

        for (ProdutoLoja p : lista()) {
            if (p.getProduto().getMarca().contains(s)) {
                temp.add(p);
            }
        }

        return temp;
    }

    /**
     *
     * @param s
     * @return
     */
    public ArrayList<ProdutoLoja> procurarReferencia(String s) {
        ArrayList<ProdutoLoja> temp = new ArrayList<>();

        for (ProdutoLoja p : lista()) {
            if (p.getProduto().getReferencia().contains(s)) {
                temp.add(p);
            }
        }

        return temp;
    }

    /**
     *
     * @param produto
     * @return
     * @throws Produtos.RepositorioProdutoLoja.ProdutoJaExisteNaLojaException
     */
    public boolean verificarExistencia(ProdutoLoja produto) throws ProdutoJaExisteNaLojaException {
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getProduto() == produto.getProduto()) {

                throw new ProdutoJaExisteNaLojaException(String.format("O Produto já existe nesta loja"));

            }
        }
        return true;
    }

    /**
     *
     *
     * @param dados
     */
    public void removeProdutoLoja(ProdutoLoja dados) {
        repositorio.remove(dados);
    }

    /**
     *
     *
     * @return
     */
    public ArrayList<ProdutoLoja> lista() {
        return new ArrayList<>(repositorio);
    }

    /**
     *
     *
     * @return
     */
    public int size() {
        return repositorio.size();
    }

    /**
     *
     *
     * @param loja
     * @return
     */
    public ArrayList listarProdutosLoja(String loja) {
        ArrayList<ProdutoLoja> lista = new ArrayList();
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getLoja().getUsername() == loja) {
                lista.add(produtoloja);
            }

        }
        return lista;
    }

    /**
     *
     *
     * @param produto
     * @return
     */
    public ArrayList listarInstanciasProdutos(Produto produto) {
        ArrayList<ProdutoLoja> lista = new ArrayList();
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getProduto() == produto) {
                lista.add(produtoloja);
            }

        }
        return lista;
    }

    /**
     *
     *
     */
    public class ProdutoJaExisteNaLojaException extends Exception {

        public ProdutoJaExisteNaLojaException() {
        }

        public ProdutoJaExisteNaLojaException(String message) {
            super(message);
        }
    }

    /**
     *
     *
     */
    public class OProdutoNaoExiste extends Exception {

        /**
         *
         *
         */
        public OProdutoNaoExiste() {
        }

        /**
         *
         *
         */
        public OProdutoNaoExiste(String message) {
            super(message);
        }
    }
}