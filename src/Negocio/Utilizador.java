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
public abstract class Utilizador {
    private String nome, passowrd;
    
    public boolean login(String username , String password){
        
        if(password == "1234" && username == "Admin"){
            return true;
        }
        return false;
    }
    
    
}
