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
     *Exception
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
     *Exception
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
     *Exception
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
     *Construtor ListaAdmins
     *
     */
    public ListaAdmins() {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    }

    /**
     *adiciona o administrador ao tree map
     *
     * @param utilizador
     * @throws Negocio.ListaAdmins.UtilizadorDuplicadoException
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
     *Verifica se o tree map contem o administrador
     *
     * @param username
     * @return
     */
    public boolean existe(String username) {
        return lista.containsKey(username);
    }

    
    /**
     *retorna o tamanho do tree map
     *
     * @return
     */
    public int size() {
        return lista.size();
    }

    /**
     *retorna o administrador
     *
     * @param username
     * @return
     * @throws Negocio.ListaAdmins.UtilizadorNaoExistenteException
     */
    public Utilizador getUtilizador(String username) throws UtilizadorNaoExistenteException {
        if (lista.containsKey(username)) {
            return lista.get(username);
        } else {
            throw new UtilizadorNaoExistenteException("O utilizador '%s' já existe na lista");
        }
    }

    /**
     *retorna um ArrayList com todos os administradore
     *
     * @return
     */
    public ArrayList<Administrador> todos() {
        return new ArrayList<>(lista.values());
    }

}
