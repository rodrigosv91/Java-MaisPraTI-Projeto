
package controller;

import dao.PessoaDAO;
import model.Pessoa;

/**
 *
 * @author Rodrigo Vieira
 */
public class Remover {
    
    PessoaDAO pDao = new PessoaDAO(); 
    
    public void removerPessoa(Pessoa pessoa) {      
        //PessoaDAO pDao =  new PessoaDAO();
        if(verificaSeExiste(pessoa.getId())){
            pDao.remover(pessoa); 
            if(!pDao.buscarTodos().contains(pDao.buscar(pessoa.getId()))){
                System.out.println("\nRemovido.");
            }
        }
        else{
            System.out.println("\nNão há pessoa ou aluno com identificação: " + pessoa.getId());
        }
    }
    
    public void removerPessoa(int id) {          
        //PessoaDAO pDao =  new PessoaDAO();       
        if(verificaSeExiste(id)){
            pDao.remover(id); 
            if(!pDao.buscarTodos().contains(pDao.buscar(id))){
                System.out.println("\nRemovido.");
            }
        }
        else{
            System.out.println("\nNão há pessoa ou aluno com identificação: " + id);
        }
    }
    
    public boolean verificaSeExiste(int id) {    
        return pDao.buscarTodos().contains(pDao.buscar(id));      
    }
    
    public boolean verificaSeVazia(){
        return pDao.buscarTodos().isEmpty();
    }
}
