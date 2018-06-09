///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package Sistema;
//
///**

import Produtos.Produto;
import Produtos.ProdutoLoja;
import Produtos.RepositorioProdutoLoja;
import Users.Loja;
import java.util.ArrayList;

// *
// * @author daniel
// */
//public class Main {
//    public static void main(String[]args) throws RepositorioProdutoLoja.ProdutoJaExisteNaLojaException, RepositorioProdutoLoja.OProdutoNaoExiste{
//////        Produto p1 = new Produto("Telemovel", "huawei", "dadsadasdada");
////        
////        RepositorioProduto r = new RepositorioProduto();
////        
////        System.out.println(r.verificarProduto("1"));
////        
////        r.registarProduto("1",p1);
////        
////        System.out.println(r.verificarProduto("1"));
////                
////        System.out.println(r.obterProduto("1"));
//
////        Produto p1 = new Produto("Telemovel", "huawei", "dadsadasdada");
////        RepositorioProduto r = new RepositorioProduto();
////        ProdutoLoja ol = new ProdutoLoja(12,true,p1);
////        Loja l = new Loja();
////        r.registarProduto("ola", p1);
////        
//       
////    
//            //converter utilizadores para lojas
//            Loja l = new Loja("manel", "manel", "manel",false,1111);
//            
//            
//            System.out.println(l.getUsername());
//            System.out.println(l.getClass());
//        
//            l = (Loja) l;
//            System.out.println(l.getClass());
//            
//            ListaUsers u = new ListaUsers();
//            
//            u.adicionar(new Administrador("admin", "admin", "Aministrador"));
//        u.adicionar(new Loja("daniel", "daniel", "daniel",true,1111));
//        u.adicionar(new Loja("quim", "quim", "quim",false,1111));
//        u.adicionar(new Loja("jose", "jose", "jose",true,1111));
//        u.adicionar(new Loja("manel", "manel", "manel",false,1111));
//        
//        
//        Loja a = new Loja();
//        for(int i = 0 ; i< u.todos().size();i++){
//            if(u.todos().get(i).getClass() == a.getClass()){
//                Loja f = (Loja) u.todos().get(i);
//                System.out.println(f.getSubscricao()+"   "+f.getClicks()+"    "+ f.getUsername()+"       "+f.getNome()+"       "+f.getPassword());
//                
//                
//            }
//            }
//        
//        System.out.println(u.Lojas().size());
//        for(int i = 0 ; i< u.Lojas().size();i++){
//            
//                System.out.println(u.Lojas().get(i).getUsername()+"   "
//                        +u.Lojas().get(i).getNome()+"    "
//                        + u.Lojas().get(i).getPassword()+"       "
//                        +u.Lojas().get(i).getSubscricao()+"       "
//                        +u.Lojas().get(i).getClicks()+"      "+u.Lojas().size());
//                
//                






//            Produto p = new Produto("f","nome","marca","referencia");
//            Produto p1 = new Produto("f","nomep1","nomep1","referenciap1");
//            
//            Loja l = new Loja("l","l","l",true,1);
//            Loja l1 = new Loja("12332113","l313231","3131231l",true,1);
//            
//            ProdutoLoja pl = new ProdutoLoja(2,true,p,l);
//            
//            ProdutoLoja pl1 = new ProdutoLoja(5,true,p,l1);
//            
//            ProdutoLoja pl2 = new ProdutoLoja(2,true,p,l1);
//            
//            ProdutoLoja pl12 = new ProdutoLoja(5,true,p1,l1);
//            
//            RepositorioProdutoLoja rep = new RepositorioProdutoLoja();
//            rep.addProdutoLoja(pl);
//            rep.addProdutoLoja(pl1);
//            
//            rep.addProdutoLoja(pl12);
//            
//            ArrayList<ProdutoLoja>d = rep.procurarProduto("nomep1");
//            for(int i = 0; i < d.size();i++){
//                System.out.println(d.get(i).getPreco());
//                System.out.println(d.get(i).getLoja().getUsername());
//            }
//            System.out.println("----------------");
//            
//            ArrayList<ProdutoLoja>q = rep.procurarProduto("nomep1");
//            for(int i = 0; i < q.size();i++){
//                System.out.println(q.get(i).getPreco());
//                System.out.println(q.get(i).getLoja().getUsername());
//            }
//            System.out.println("----------------");
//            
//            ArrayList<ProdutoLoja>x = rep.procurarProduto("1");
//            for(int i = 0; i < x.size();i++){
//                System.out.println(x.get(i).getPreco());
//                System.out.println(x.get(i).getLoja().getUsername());
//            }
//            
//            System.out.println("--------------------");
//            
//            ArrayList<ProdutoLoja>v = rep.procurarProduto("referencia");
//            for(int i = 0; i < v.size();i++){
//                System.out.println(v.get(i).getPreco());
//                System.out.println(v.get(i).getLoja().getUsername());
//            }
//            
//           }
// }
//        
//            
//}
//
// Produto p = new Produto("ola","ola","ola","ola");
//          
//          Loja l = new Loja("daniel","daniel","daniel",true,2);
//          
//          ProdutoLoja r = new ProdutoLoja(2,true,p,l);
//          
//          RepositorioProdutoLoja u = new RepositorioProdutoLoja();
//        
//        u.addProdutoLoja(r);
//        
//        System.out.println(r.getLoja().getNome());
//        System.out.println(r.getProduto().getNomeProduto());
    
