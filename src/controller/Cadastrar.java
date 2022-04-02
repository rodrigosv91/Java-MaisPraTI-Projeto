
package controller;

import dao.AlunoDAO;
import dao.PessoaDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import model.Aluno;
import model.Pessoa;
import utils.Contador;

/**
 * 
 * @author Rodrigo Vieira
 */
public class Cadastrar {
    
    public void cadastrarPessoa(String nome, String telefone, LocalDate dataNascimento){
        
        Pessoa pessoa = new Pessoa(Contador.next(),nome, telefone, dataNascimento, LocalDateTime.now(), LocalDateTime.now());       
        PessoaDAO pDao = new PessoaDAO();
        pDao.adicionar(pessoa);       
    }
    
    public void cadastrarAluno(String nome, String telefone, LocalDate dataNascimento, double notaFinal){
        
        Aluno aluno = new Aluno(Contador.next(),nome, telefone, dataNascimento, LocalDateTime.now(), LocalDateTime.now(), notaFinal);       
        AlunoDAO aDao = new AlunoDAO(); 
        aDao.adicionar(aluno);
    }
}
