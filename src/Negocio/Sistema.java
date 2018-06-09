/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Negocio.Produto;
import Negocio.RepositorioProdutoLoja;
import Negocio.RepositorioProduto;
import Negocio.Administrador;
import Negocio.Loja;
import Negocio.ListaAdmins;
import Negocio.ListaLojas;
import Negocio.Utilizador;
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
     *
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
     *
     *
     * @return
     */
    public ListaAdmins getListaAdmins() {
        return admins;
    }

    /**
     *
     *
     * @return
     */
    public ListaLojas getListaLojas() {
        return lojas;
    }

    /**
     *
     *
     * @return
     */
    public RepositorioProduto getListaProduto() {
        return rep;
    }

    /**
     *
     *
     * @return
     */
    public RepositorioProdutoLoja getListaProdutoLoja() {
        return repProdutoLoja;
    }

    /**
     *
     *
     * @param username
     * @param password
     * @return
     * @throws Users.ListaAdmins.UtilizadorNaoExistenteException
     * @throws Users.ListaLojas.UtilizadorNaoExistenteException
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
     *
     *
     * @return
     */
    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }

    /**
     *
     *
     * @throws Users.ListaAdmins.UtilizadorDuplicadoException
     * @throws Produtos.RepositorioProduto.ProdutoDuplicadoException
     * @throws Users.ListaLojas.UtilizadorDuplicadoException
     */
    public void inicializar() throws ListaAdmins.UtilizadorDuplicadoException, RepositorioProduto.ProdutoDuplicadoException, ListaLojas.UtilizadorDuplicadoException {
        admins.adicionar(new Administrador("admin", "admin", "Aministrador"));
        lojas.adicionar(new Loja("daniel", "daniel", "daniel", true, 1111));
        lojas.adicionar(new Loja("quim", "quim", "quim", false, 1111));
        rep.registarProduto(produto);
    }

    /**
     *
     *
     */
    public void terminar() {
        System.exit(0);
    }
}
