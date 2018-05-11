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
public class Main {
    public static void main(String[]args){
        Produto p1 = new Produto("Telemovel", "huawei", "dadsadasdada");
        
        RepositorioProduto r = new RepositorioProduto();
        
        System.out.println(r.verificarProduto("1"));
        
        r.registarProduto("1",p1);
        
        System.out.println(r.verificarProduto("1"));
                
        System.out.println(r.obterProduto("1"));
    }
}
