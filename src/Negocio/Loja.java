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
public class Loja extends Utilizador implements Serializable {

    private boolean subscricao;
    private int clicks;
    private int clicksUsados;

    /**
     *contrutor Loja
     *
     */
    public Loja() {
    }

    /**
     *construtor Loja
     *
     * @param username
     * @param password
     * @param nome
     * @param subscricao
     * @param clicks
     */
    public Loja(String username, String password, String nome, boolean subscricao, int clicks) {
        super(username, password, nome);
        this.subscricao = subscricao;
        this.clicks = clicks;

    }

    /**
     *get username
     *
     * @return
     */
    @Override
    public String getUsername() {
        return super.getUsername();
    }

    /**
     *get password
     *
     * @return
     */
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    /**
     *get nome
     *
     * @return
     */
    @Override
    public String getNome() {
        return super.getNome();
    }

    /**
     *get clicks restantes
     *
     * @return
     */
    public int getClicksRestantes() {
        return (clicks - clicksUsados);
    }

    /**
     *get clicks usados
     *
     */
    public void addClickUsados() {
        clicksUsados++;
    }

    /**
     *get subscricao
     *
     * @return
     */
    public boolean getSubscricao() {
        return subscricao;
    }

    /**
     *set susbscricao
     *
     * @param subscricao
     */
    public void setSubscricao(boolean subscricao) {
        this.subscricao = subscricao;
    }

    /**
     *get clicks
     *
     * @return
     */
    public int getClicks() {
        return clicks;
    }

    /**
     *set clicks
     *
     * @param clicks
     */
    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    /**
     *get clicks usados
     *
     * @return
     */
    public int getClicksUsados() {
        return clicksUsados;
    }

    /**
     *set clicks usados
     *
     * @param clicksUsados
     */
    public void setClicksUsados(int clicksUsados) {
        this.clicksUsados = clicksUsados;
    }

}
