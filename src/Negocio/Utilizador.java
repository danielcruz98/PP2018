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
public class Utilizador implements Serializable {

    private String username;
    private String password;
    private String nome;

    /**
     *construtor Utilizador
     *
     */
    public Utilizador() {
    }

    /**
     *construtor Utilizador
     *
     * @param username
     * @param password
     * @param nome
     */
    public Utilizador(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
    }

    /**
     *get usernam
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *set username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *get password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *set password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *get nome
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *set nome
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
