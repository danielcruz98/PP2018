/*To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import Users.Loja;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class RepositorioProdutoLoja implements Serializable {

    private ArrayList<ProdutoLoja> repositorio;
    private static final RepositorioProdutoLoja INSTANCE = new RepositorioProdutoLoja();

    public RepositorioProdutoLoja() {
        repositorio = new ArrayList();
    }

    public void addProdutoLoja(ProdutoLoja dados) throws ProdutoJaExisteNaLojaException {

        verificarExistencia(dados);
        repositorio.add(dados);

    }
    
    public ProdutoLoja getProdutoLoja(int i){
        return repositorio.get(i);
    }    
    
    //fazer 3 metodos diferentes de forma a procurar cada um sozoinho
   
    
    public ArrayList<ProdutoLoja> procurarNome(String s){
        ArrayList<ProdutoLoja> temp = new ArrayList<>();
        
        for(ProdutoLoja p : lista()){
            if(p.getProduto().getNomeProduto().contains(s)){
                temp.add(p);
            }
        }
        
        return temp;
    }
  public ArrayList<ProdutoLoja> procurarMarca(String s){
        ArrayList<ProdutoLoja> temp = new ArrayList<>();
        
        for(ProdutoLoja p : lista()){
            if(p.getProduto().getMarca().contains(s)){
                temp.add(p);
            }
        }
        
        return temp;
    }
   public ArrayList<ProdutoLoja> procurarReferencia(String s){
        ArrayList<ProdutoLoja> temp = new ArrayList<>();
        
        for(ProdutoLoja p : lista()){
            if(p.getProduto().getReferencia().contains(s)){
                temp.add(p);
            }
        }
        
        return temp;
    }
    public boolean verificarExistencia(ProdutoLoja produto) throws ProdutoJaExisteNaLojaException {
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getProduto() == produto.getProduto()) {

                throw new ProdutoJaExisteNaLojaException(String.format("O Produto já existe nesta loja"));

            }
        }
        return true;
    }

    public void removeProdutoLoja(ProdutoLoja dados) {
        repositorio.remove(dados);
    }

    public ArrayList<ProdutoLoja> lista() {
        return new ArrayList<>(repositorio);
    }

    public int size() {
        return repositorio.size();
    }

    public ArrayList listarProdutosLoja(String loja) {
        ArrayList<ProdutoLoja> lista = new ArrayList();
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getLoja().getUsername() == loja) {
                lista.add(produtoloja);
            }

        }
        return lista;
    }

    public ArrayList listarInstanciasProdutos(Produto produto) {
        ArrayList<ProdutoLoja> lista = new ArrayList();
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getProduto() == produto) {
                lista.add(produtoloja);
            }

        }
        return lista;
    }

//    public ArrayList listarInstanciasProdutosEmLojasComCliquesDisponiveis(Produto produto) {
//        ArrayList<ProdutoLoja> lista = new ArrayList();
//        for (ProdutoLoja produtoloja : repositorio) {
//            if (produtoloja.getProduto() == produto && produtoloja.getLoja().getClicksRestantes() > 0) {
//                lista.add(produtoloja);
//            }
//
//        }
//        return lista;
//    }

    public class ProdutoJaExisteNaLojaException extends Exception {

        public ProdutoJaExisteNaLojaException() {
        }

        public ProdutoJaExisteNaLojaException(String message) {
            super(message);
        }
    }
    
    
    
    public class OProdutoNaoExiste extends Exception {

        public OProdutoNaoExiste() {
        }

        public OProdutoNaoExiste(String message) {
            super(message);
        }
    }
}
