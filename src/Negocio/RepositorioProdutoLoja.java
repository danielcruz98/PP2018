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
public class RepositorioProdutoLoja implements Serializable{

    //pq???
    public RepositorioProdutoLoja() {
    }

    private ArrayList<ProdutoLoja> repositorio = new ArrayList();
    private static final RepositorioProdutoLoja INSTANCE = new RepositorioProdutoLoja();

    public void addProdutoLoja(ProdutoLoja dados) throws ProdutoJaExisteNaLojaException {
        verificarExistencia(dados);
        repositorio.add(dados);
    }

    public void removeProdutoLoja(ProdutoLoja dados) {
        repositorio.remove(dados);
    }

    public ArrayList listarProdutosLoja(Loja loja) {
        ArrayList<ProdutoLoja> lista = new ArrayList();
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getLoja() == loja) {
                lista.add(produtoloja);
            }
            lista.add(produtoloja);
        }
        return lista;
    }
    public ArrayList listarInstanciasProdutos(Produto produto) {
        ArrayList<ProdutoLoja> lista = new ArrayList();
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getProduto() == produto) {
                lista.add(produtoloja);
            }
            lista.add(produtoloja);
        }
        return lista;
    }
    public ArrayList listarInstanciasProdutosEmLojasComCliquesDisponiveis(Produto produto) {
        ArrayList<ProdutoLoja> lista = new ArrayList();
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getProduto() == produto && produtoloja.getLoja().getClicksRestantes()>0) {
                lista.add(produtoloja);
            }
            lista.add(produtoloja);
        }
        return lista;
    }
    
    public boolean verificarExistencia(ProdutoLoja produto) throws ProdutoJaExisteNaLojaException {
        for (ProdutoLoja produtoloja : repositorio) {
            if (produtoloja.getProduto() == produto.getProduto() && produtoloja.getLoja()== produto.getLoja()) {
                 
                 throw new ProdutoJaExisteNaLojaException("O Produto já existe nesta loja");
                 
            }
        }
        return true;
    };
        public class ProdutoJaExisteNaLojaException extends Exception {
        public ProdutoJaExisteNaLojaException() { }
        public ProdutoJaExisteNaLojaException(String message) {
           super(message);
       }        
   }
}