/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;

/**
 *
 * @author daniel
 */
public class Sistema implements Serializable {

    private final ListaAdmins admins;
    private final ListaLojas lojas;
    private final RepositorioProduto rep;
    private Utilizador utilizadorLigado;
    private final Produto produto;
    private final RepositorioProdutoLoja repProdutoLoja;

    /**
     *construtor sistema
     *
     */
    public Sistema() {
        admins = new ListaAdmins();
        lojas = new ListaLojas();
        rep = new RepositorioProduto();
        produto = new Produto("dada", "dada", "dada", "dada");
        repProdutoLoja = new RepositorioProdutoLoja();
    }

    /**
     *retorna um objeto com todos os metodos da lista admins
     *
     * @return
     */
    public ListaAdmins getListaAdmins() {
        return admins;
    }

    /**
     *retorna um objeto com todos os metodos da lista lojas
     *
     * @return
     */
    public ListaLojas getListaLojas() {
        return lojas;
    }

    /**
     *retorna um objeto com todos os metodos do produto
     *
     * @return
     */
    public RepositorioProduto getListaProduto() {
        return rep;
    }

    /**
     *retorna um objeto com todos os metodos do produto loja
     *
     * @return
     */
    public RepositorioProdutoLoja getListaProdutoLoja() {
        return repProdutoLoja;
    }

    /**
     *faz a autenticacao do utilizador
     *
     * @param username
     * @param password
     * @return
     * @throws Negocio.ListaAdmins.UtilizadorNaoExistenteException
     * @throws Negocio.ListaLojas.UtilizadorNaoExistenteException
     */
    public boolean autenticarUtilizador(String username, String password) throws ListaAdmins.UtilizadorNaoExistenteException, ListaLojas.UtilizadorNaoExistenteException {

        Administrador a = new Administrador();
        if (lojas.existe(username) && lojas.getUtilizador(username) instanceof Loja) {
            try {
                Loja u = (Loja) lojas.getUtilizador(username);
                if (u.getPassword().equals(password) && u.getSubscricao() == true) {
                    utilizadorLigado = u;
                    return true;
                }
            } catch (Exception e) {
            }
        } else if (admins.existe(username) && admins.getUtilizador(username) instanceof Administrador) {
            try {
                Utilizador u = admins.getUtilizador(username);
                if (u.getPassword().equals(password)) {
                    utilizadorLigado = u;
                    return true;
                }
            } catch (Exception e) {
            }

        }
        return false;

    }

    /**
     *retorna o utilizador que se encontra ligado
     *
     * @return
     */
    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }

    /**
     *iniciliza o sistema
     *
     * @throws Negocio.ListaAdmins.UtilizadorDuplicadoException
     * @throws Negocio.RepositorioProduto.ProdutoDuplicadoException
     * @throws Negocio.ListaLojas.UtilizadorDuplicadoException
     */
    public void inicializar() throws ListaAdmins.UtilizadorDuplicadoException, RepositorioProduto.ProdutoDuplicadoException, ListaLojas.UtilizadorDuplicadoException {
        admins.adicionar(new Administrador("admin", "admin", "Aministrador"));
        lojas.adicionar(new Loja("daniel", "daniel", "daniel", true, 1111));
        lojas.adicionar(new Loja("quim", "quim", "quim", false, 1111));
        rep.registarProduto(produto);
    }

    /**
     *termina o programa
     *
     */
    public void terminar() {
        System.exit(0);
    }
}
