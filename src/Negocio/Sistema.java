/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class Sistema {
    private final ListaUsers utilizadores;
    private Utilizador utilizadorLigado;

    public Sistema() {
        utilizadores = new ListaUsers();   
    }                       

    public ListaUsers getListaUtilizadores() {
        return utilizadores;
    }
    
   
    
    public boolean autenticarUtilizador(String username, String password) {        
        if (utilizadores.existe(username)) {
            try{
                Utilizador u = utilizadores.getUtilizador(username);                
                if (u.getPassword().equals(password)){
                    utilizadorLigado = u; 
                    return true;
                }                
            }catch (Exception e) {}                        
        }        
        return false;        
    }
    
    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }
    
    public void inicializar() throws ListaUsers.UtilizadorDuplicadoException {
        utilizadores.adicionar(new Administrador("admin", "admin", "Aministrador"));
        utilizadores.adicionar(new Utilizador("daniel", "daniel", "Utilizador 1"));     
    }
    
    public void terminar() {
        System.exit(0);
    }
}
