/*To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Produtos;

import Negocio.Users.Loja;
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
    public ArrayList<ProdutoLoja> procurarProduto(String s){
       ArrayList<ProdutoLoja> p = new ArrayList<>();
        
        for(ProdutoLoja l : repositorio){
            if(l.getProduto().getMarca() == s){
                p.add(l);
            }else if(l.getProduto().getNomeProduto()== s){
                p.add(l);
            }else if(l.getProduto().getReferencia()== s){
                 p.add(l);
            }
        }
        return p;
    }
    
    public boolean verificarExistencia(ProdutoLoja produto) throws ProdutoJaExisteNaLojaException {
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getProduto() == produto.getProduto() && produtoloja.getLoja() == produto.getLoja()) {

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

    public ArrayList listarProdutosLoja(Loja loja) {
        ArrayList<ProdutoLoja> lista = new ArrayList();
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getLoja() == loja) {
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

    public ArrayList listarInstanciasProdutosEmLojasComCliquesDisponiveis(Produto produto) {
        ArrayList<ProdutoLoja> lista = new ArrayList();
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getProduto() == produto && produtoloja.getLoja().getClicksRestantes() > 0) {
                lista.add(produtoloja);
            }

        }
        return lista;
    }

    public class ProdutoJaExisteNaLojaException extends Exception {

        public ProdutoJaExisteNaLojaException() {
        }

        public ProdutoJaExisteNaLojaException(String message) {
            super(message);
        }
    }
    
    public class NaoConsegueEncontrar extends Exception {

        public NaoConsegueEncontrar() {
        }

        public NaoConsegueEncontrar(String message) {
            super(message);
        }
    }
}
