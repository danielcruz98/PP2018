///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Negocio;
//
///**
// *
// * @author daniel
// */
//public class Main {
//    public static void main(String[]args) throws RepositorioProduto.ProdutoDuplicadoException, ListaUsers.UtilizadorDuplicadoException, ListaUsers.UtilizadorNaoExistenteException{
////        Produto p1 = new Produto("Telemovel", "huawei", "dadsadasdada");
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
//            }
//            }
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
//
