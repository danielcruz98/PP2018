/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author daniel
 */
public class ListaAdmins implements Serializable {

    private TreeMap<String, Administrador> lista;

    /**
     *
     *
     */
    public class UtilizadorNaoExistenteException extends Exception {

        public UtilizadorNaoExistenteException() {
        }

        public UtilizadorNaoExistenteException(String message) {
            super(message);
        }
    }

    /**
     *
     *
     */
    public class UtilizadorDuplicadoException extends Exception {

        public UtilizadorDuplicadoException() {
        }

        public UtilizadorDuplicadoException(String message) {
            super(message);
        }
    }

    /**
     *
     *
     */
    public class NaoVisita extends Exception {

        public NaoVisita() {
        }

        public NaoVisita(String message) {
            super(message);
        }
    }

    /**
     *
     *
     */
    public ListaAdmins() {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    }

    /**
     *
     *
     * @param utilizador
     * @throws Users.ListaAdmins.UtilizadorDuplicadoException
     */
    public void adicionar(Administrador utilizador) throws UtilizadorDuplicadoException {
        if (utilizador == null) {
            throw new NullPointerException("O parâmetro 'utilizador' não pode ser um valor nulo");
        }

        if (!lista.containsKey(utilizador.getUsername())) {
            lista.put(utilizador.getUsername(), utilizador);
        } else {
            throw new UtilizadorDuplicadoException(String.format("O utilizador '%s' já existe na coleção", utilizador.getUsername()));
        }

    }

    /**
     *
     *
     * @param username
     * @return
     */
    public boolean existe(String username) {
        return lista.containsKey(username);
    }

    public int size() {
        return lista.size();
    }

    /**
     *
     *
     * @param username
     * @return
     * @throws Users.ListaAdmins.UtilizadorNaoExistenteException
     */
    public Utilizador getUtilizador(String username) throws UtilizadorNaoExistenteException {
        if (lista.containsKey(username)) {
            return lista.get(username);
        } else {
            throw new UtilizadorNaoExistenteException("O utilizador '%s' já existe na lista");
        }
    }

    /**
     *
     *
     * @return
     */
    public ArrayList<Administrador> todos() {
        return new ArrayList<>(lista.values());
    }

}
