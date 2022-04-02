
package controller;

import dao.AlunoDAO;
import dao.PessoaDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import model.Aluno;
import model.Pessoa;

/**
 *
 * @author Rodrigo Vieira
 */
public class Atualizar {
    
    public void atualizarPessoa(int id, String nome, String telefone, LocalDate dataNascimento) {
        
        PessoaDAO pDao = new PessoaDAO();       
        Pessoa pessoa = pDao.buscarComoPessoa(id);
        pessoa.setNome(nome);
        pessoa.setTelefone(telefone);
        pessoa.setDataNascimento(dataNascimento); 
        pessoa.setDataAlteracao(LocalDateTime.now());               
        pDao.atualizar(pessoa); 
    }
    
    public void atualizarAluno(int id, String nome, String telefone, LocalDate dataNascimento, double notaFinal) {
        
        AlunoDAO aDao = new AlunoDAO();     
        Aluno aluno = aDao.buscarComoAluno(id);
        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setDataNascimento(dataNascimento); 
        aluno.setDataAlteracao(LocalDateTime.now()); 
        aluno.setNotaFinal(notaFinal);             
        aDao.atualizar(aluno);        
    }
    
    public boolean verificaSeExiste(int id) {
        PessoaDAO pDao = new PessoaDAO();        
        return pDao.buscarTodos().contains(pDao.buscar(id));      
    }
        
    public boolean verificaSeVazia(){
        PessoaDAO pDao = new PessoaDAO(); 
        return pDao.buscarTodos().isEmpty();
    }
}
