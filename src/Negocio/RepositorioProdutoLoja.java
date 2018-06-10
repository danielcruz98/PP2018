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

    /**
     * construtor RepositorioProdutoLoja
     *
     */
    public RepositorioProdutoLoja() {
        repositorio = new ArrayList();
    }

    /**
     * adiciona um produto loja ao array list
     *
     * @param dados
     * @throws Negocio.RepositorioProdutoLoja.ProdutoJaExisteNaLojaException
     */
    public void addProdutoLoja(ProdutoLoja dados) throws ProdutoJaExisteNaLojaException {

        verificarExistencia(dados);
        repositorio.add(dados);

    }

    /**
     * retorna o produto loja
     *
     * @param l
     * @param p
     * @return
     */
    public ProdutoLoja getProdutoLoja(String l, String p) {

        ProdutoLoja temp = new ProdutoLoja();

        for (ProdutoLoja u : lista()) {
            if (u.getProduto().getCodigoBarras().contains(p) && u.getLoja().getUsername() == l) {
                temp = u;
            }
        }

        return temp;
    }

    //fazer 3 metodos diferentes de forma a procurar cada um sozoinho
    /**
     * procura o produto loja pelo nome do produto
     *
     * @param s
     * @return
     */
    public ArrayList<ProdutoLoja> procurarNome(String s) {
        ArrayList<ProdutoLoja> temp = new ArrayList<>();

        for (ProdutoLoja p : lista()) {
            if (p.getProduto().getNomeProduto().contains(s) && p.getLoja().getSubscricao() == true) {
                temp.add(p);
            }
        }

        return temp;
    }

    /**
     * procura o produto loja pela marca do produto
     *
     * @param s
     * @return
     */
    public ArrayList<ProdutoLoja> procurarMarca(String s) {
        ArrayList<ProdutoLoja> temp = new ArrayList<>();

        for (ProdutoLoja p : lista()) {
            if (p.getProduto().getMarca().contains(s) && p.getLoja().getSubscricao() == true) {
                temp.add(p);
            }
        }

        return temp;
    }

    /**
     * procura o produto loja pela referencia do produto
     *
     * @param s
     * @return
     */
    public ArrayList<ProdutoLoja> procurarReferencia(String s) {
        ArrayList<ProdutoLoja> temp = new ArrayList<>();

        for (ProdutoLoja p : lista()) {
            if (p.getProduto().getReferencia().contains(s) && p.getLoja().getSubscricao() == true) {
                temp.add(p);
            }
        }

        return temp;
    }

    /**
     * verifica se o produto loja existe no array list
     *
     * @param produto
     * @return
     * @throws Negocio.RepositorioProdutoLoja.ProdutoJaExisteNaLojaException
     */
    public boolean verificarExistencia(ProdutoLoja produto) throws ProdutoJaExisteNaLojaException {
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getProduto() == produto.getProduto() && produtoloja.getLoja() == produto.getLoja()) {

                throw new ProdutoJaExisteNaLojaException(String.format("O Produto já existe nesta loja"));

            }
        }
        return true;
    }

    /**
     * retorna um array list de todos os produtos lojas
     *
     * @return
     */
    public ArrayList<ProdutoLoja> lista() {
        return new ArrayList<>(repositorio);
    }

    /**
     * retorna o tamanho do array list
     *
     * @return
     */
    public int size() {
        return repositorio.size();
    }

    /**
     * retorna um array list com todos os produtos de uma determinada loja
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
     * Exception
     *
     */
    public class ProdutoJaExisteNaLojaException extends Exception {

        /**
         * Exception
         *
         */
        public ProdutoJaExisteNaLojaException() {
        }

        /**
         * Exception
         *
         * @param message
         */
        public ProdutoJaExisteNaLojaException(String message) {
            super(message);
        }
    }

    /**
     * Exception
     *
     */
    public class OProdutoNaoExiste extends Exception {

        /**
         * Exception
         *
         */
        public OProdutoNaoExiste() {
        }

        /**
         * Exception
         *
         * @param message
         */
        public OProdutoNaoExiste(String message) {
            super(message);
        }
    }
}
