/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class Sistema implements Serializable{

    private final ListaUsers utilizadores;
    private final RepositorioProduto rep;
    private Utilizador utilizadorLigado;
    private Produto produto;

    public Sistema() {
        utilizadores = new ListaUsers();
        rep = new RepositorioProduto();
        produto = new Produto("dada", "dada", "dada", "dada");
    }

    public ListaUsers getListaUtilizadores() {
        return utilizadores;
    }

    public RepositorioProduto getListaProduto() {
        return rep;
    }

    public boolean autenticarUtilizador(String username, String password) throws ListaUsers.UtilizadorNaoExistenteException {
        Loja l = new Loja();
        Administrador a = new Administrador();
        if (utilizadores.existe(username) && utilizadores.getUtilizador(username).getClass() == l.getClass()) {
            try {
                Loja u = (Loja) utilizadores.getUtilizador(username);
                if (u.getPassword().equals(password) && u.getSubscricao()==true) {
                    utilizadorLigado = u;
                    return true;
                }
            } catch (Exception e) {
            }
        }else if(utilizadores.existe(username) && utilizadores.getUtilizador(username).getClass() == a.getClass()) {
            try {
                Utilizador u =  utilizadores.getUtilizador(username);
                if (u.getPassword().equals(password)) {
                    utilizadorLigado = u;
                    return true;
                }
            } catch (Exception e) {
            }
        
        
        }
        return false;
        
    }

    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }

    public void inicializar() throws ListaUsers.UtilizadorDuplicadoException, RepositorioProduto.ProdutoDuplicadoException {
        utilizadores.adicionar(new Administrador("admin", "admin", "Aministrador"));
        utilizadores.adicionar(new Loja("daniel", "daniel", "daniel",true,1111));
        utilizadores.adicionar(new Loja("quim", "quim", "quim",false,1111));
        rep.registarProduto(produto);
    }

    public void terminar() {
        System.exit(0);
    }
}
