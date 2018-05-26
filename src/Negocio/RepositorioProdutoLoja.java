/*To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Negocio.Loja;
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
        for (ProdutoLoja produto : repositorio){
            if (produto.getProduto() == dados.getProduto() && produto.getLoja() == dados.getLoja()) {
            throw new ProdutoJaExisteNaLojaException("O Produto já existe nesta loja");
            
            }
        }
        repositorio.add(dados);
    }

    public boolean verificarExistencia(ProdutoLoja produto) throws ProdutoJaExisteNaLojaException {
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getProduto() == produto.getProduto() && produtoloja.getLoja() == produto.getLoja()) {

                throw new ProdutoJaExisteNaLojaException("O Produto já existe nesta loja");

            }
        }
        return true;
    }
    public void removeProdutoLoja(ProdutoLoja dados) {
        repositorio.remove(dados);
    }

    public ArrayList <ProdutoLoja> Lista(){
        return new ArrayList<>(repositorio);
    }
    
    public int size(){
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
}
