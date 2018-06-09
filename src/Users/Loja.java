/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

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
     *
     *
     */
    public Loja() {
    }

    /**
     *
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
     *
     *
     * @return
     */
    @Override
    public String getUsername() {
        return super.getUsername();
    }

    /**
     *
     *
     * @return
     */
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    /**
     *
     *
     * @return
     */
    @Override
    public String getNome() {
        return super.getNome();
    }

    /**
     *
     *
     * @return
     */
    public int getClicksRestantes() {
        return (clicks - clicksUsados);
    }

    /**
     *
     * @author daniel
     */
    public void addClickUsados() {
        clicksUsados++;
    }

    /**
     *
     *
     * @return
     */
    public boolean getSubscricao() {
        return subscricao;
    }

    /**
     *
     *
     * @param subscricao
     */
    public void setSubscricao(boolean subscricao) {
        this.subscricao = subscricao;
    }

    /**
     *
     *
     * @return
     */
    public int getClicks() {
        return clicks;
    }

    /**
     *
     *
     * @param clicks
     */
    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    /**
     *
     *
     * @return
     */
    public int getClicksUsados() {
        return clicksUsados;
    }

    /**
     *
     *
     * @param clicksUsados
     */
    public void setClicksUsados(int clicksUsados) {
        this.clicksUsados = clicksUsados;
    }

}
