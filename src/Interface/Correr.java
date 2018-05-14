/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JOptionPane;
import Negocio.Sistema;

/**
 *
 * @author daniel
 */
public class Correr {
     public static void main(String[] args) {
        Sistema sistema = new Sistema();                
        
        try {                                                
            //Inicializa o sistema
            sistema.inicializar();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, 
                    String.format("Ocorreu um erro ao inicializar o sistema: %s.\nO programa será encerrado.",
                        ex.getMessage()), 
                    "Erro fatal", JOptionPane.ERROR_MESSAGE);
            sistema.terminar();
        }
        
        //Uma vez que a JanelaLogin é modal, este método irá bloquear até que a janela seja fechada.
        //A janela só fecha quando os dados de login são válidos.                
        Login login = new Login(sistema);               
        login.setVisible(true);
    
        Principal principal = new Principal(sistema);
        principal.setVisible(true);        
        
    }     
}
