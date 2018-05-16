/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author daniel
 */
public class Loja extends Utilizador {

    private boolean subscricao;
    private int clicks;
    private int clicksUsados;
    private RepositorioProdutoLoja repositorio;

    public Loja() {
    }

    public Loja(String username, String password, String nome, boolean subscricao, int clicks) {
        super(username, password, nome);
        this.subscricao = subscricao;
        this.clicks = clicks;
    }

    public int getClicksRestantes() {
        return (clicks - clicksUsados);
    }

    public void addClickUsados() {
        clicksUsados++;
    }

    public boolean getSubscricao() {
        return subscricao;
    }

    public void setSubscricao(boolean subscricao) {
        this.subscricao = subscricao;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getClicksUsados() {
        return clicksUsados;
    }

    public void setClicksUsados(int clicksUsados) {
        this.clicksUsados = clicksUsados;
    }

}
