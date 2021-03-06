/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.Administrador;
import Negocio.ListaAdmins;
import Negocio.Loja;
import Negocio.Sistema;
import Negocio.ListaLojas;
import BaseDados.Serializacao;

/**
 *
 * @author daniel
 */
public class Correr {

    /**
     *
     *
     * @param args
     * @throws Negocio.ListaAdmins.UtilizadorDuplicadoException
     * @throws Negocio.ListaLojas.UtilizadorDuplicadoException
     */
    public static void main(String[] args) throws ListaAdmins.UtilizadorDuplicadoException, ListaLojas.UtilizadorDuplicadoException {

        Sistema sistema;
        String ficheiroDados = String.format("%s\\Terminado.data", System.getProperty("user.dir"));
        System.out.println(String.format("Ficheiro de dados: %s.", ficheiroDados));
        Serializacao bd = new Serializacao(ficheiroDados);

        if (!bd.getFicheiro().exists()) {

            sistema = new Sistema();
            //Adiciona quatro utilizadores para que possa ser possivel entrar no sistema
            sistema.getListaAdmins().adicionar(new Administrador("admin", "admin", "Aministrador"));
            sistema.getListaLojas().adicionar(new Loja("daniel", "daniel", "daniel", true, 1111));
            sistema.getListaLojas().adicionar(new Loja("quim", "quim", "quim", true, 1111));
            sistema.getListaLojas().adicionar(new Loja("da", "da", "da", true, 1111));
        } else {
            sistema = bd.carregar();
        }

        inicioJanelaProcurarProduto login = new inicioJanelaProcurarProduto(sistema, bd);
        login.setVisible(true);

    }

}
