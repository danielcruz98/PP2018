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
public class Administrador extends Utilizador implements Serializable {

    /**
     *
     *
     */
    public Administrador() {
    }

    /**
     *
     *
     * @param username
     * @param password
     * @param nome
     */
    public Administrador(String username, String password, String nome) {
        super(username, password, nome);
    }
}
