
package dao;

import dao.interfaceDAO.Operacoes;
import java.util.ArrayList;
import model.Aluno;
import model.Pessoa;
import repository.PessoaRepository;

/**
 *
 * @author Rodrigo Vieira
 */
public class AlunoDAO implements Operacoes{

    @Override
    public void adicionar(Pessoa pessoa) {
        Aluno aluno = (Aluno) pessoa;
        PessoaRepository.inserir(aluno);
    }

    @Override
    public void remover(Pessoa pessoa) {
        PessoaRepository.remover(pessoa.getId()); 
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        Aluno aluno = (Aluno) pessoa;
        PessoaRepository.atualizar(aluno);
    }

    @Override
    public ArrayList<Pessoa> buscarTodos() {
        return PessoaRepository.getLista(); 
    }
    
    @Override
    public Aluno buscar(int idAluno){
        return (Aluno) PessoaRepository.getPessoaPorId(idAluno);
    }
    
    public Aluno buscarComoAluno(int idAluno){
        if(PessoaRepository.getPessoaPorId(idAluno) instanceof Aluno){
            //Se Aluno, retorna com casting  
            return (Aluno) PessoaRepository.getPessoaPorId(idAluno); 
        }else{          
            //Se não, busca como se fosse Aluno com dados disponiveis de pessoa
            Pessoa pessoa = PessoaRepository.getPessoaPorId(idAluno);
            Aluno aluno = new Aluno();
            aluno.setId(idAluno);
            aluno.setNome(pessoa.getNome());
            aluno.setTelefone(pessoa.getTelefone()); 
            aluno.setDataNascimento(pessoa.getDataNascimento());
            aluno.setDataCadastro(pessoa.getDataCadastro());
            aluno.setDataAlteracao(pessoa.getDataAlteracao());
            //aluno.setNotaFinal();
            return aluno;
        }        
    }
}
