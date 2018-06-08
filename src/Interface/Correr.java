/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.Users.Administrador;
import Negocio.Users.ListaUsers;
import Negocio.Users.Loja;
import javax.swing.JOptionPane;
import Negocio.Sistema;
import Negocio.Users.Utilizador;
import bd.Serializacao;

/**
 *
 * @author daniel
 */
public class Correr {
     public static void main(String[] args) throws ListaUsers.UtilizadorDuplicadoException {
        
        Sistema sistema;        
        String ficheiroDados = String.format("%s\\di.data", System.getProperty("user.dir"));
        System.out.println(String.format("Ficheiro de dados: %s.", ficheiroDados));
        Serializacao bd = new Serializacao(ficheiroDados);        
        
       
        if (! bd.getFicheiro().exists()) {
            
            sistema = new Sistema();      
            //Adiciona dois utilizadores para que possa ser possivel entrar no sistema
            sistema.getListaUtilizadores().adicionar(new Administrador("admin", "admin", "Aministrador"));
        sistema.getListaUtilizadores().adicionar(new Loja("daniel", "daniel", "daniel",true,1111));
         sistema.getListaUtilizadores().adicionar(new Loja("quim", "quim", "quim",false,1111));                
        }else{
            sistema = bd.carregar();            
        }                 
        
               
        Login login = new Login(sistema);               
        login.setVisible(true);
    
        Principal principal = new Principal(sistema, bd);
        principal.setVisible(true);        
        
    }
         
        
}
