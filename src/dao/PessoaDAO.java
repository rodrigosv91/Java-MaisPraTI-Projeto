
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
public class PessoaDAO implements Operacoes{

    @Override
    public void adicionar(Pessoa pessoa) {
        PessoaRepository.inserir(pessoa);
    }

    @Override 
    public void remover(Pessoa pessoa) {
        PessoaRepository.remover(pessoa.getId());
    }
    
    public void remover(int id) {
        PessoaRepository.remover(id);
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        PessoaRepository.atualizar(pessoa); 
    }

    @Override
    public ArrayList<Pessoa> buscarTodos() {
        return PessoaRepository.getLista(); 
    }
    
    @Override
    public Pessoa buscar(int idPessoa){ 
        return PessoaRepository.getPessoaPorId(idPessoa);
    }
    
    public Pessoa buscarComoPessoa(int idPessoa){     
        if(PessoaRepository.getPessoaPorId(idPessoa) instanceof Aluno){
            //Se Aluno, substitui por Pessoa
            Pessoa oldPessoa = PessoaRepository.getPessoaPorId(idPessoa);
            Pessoa novaPessoa = new Pessoa();
            novaPessoa.setId(idPessoa);
            novaPessoa.setNome(oldPessoa.getNome());
            novaPessoa.setTelefone(oldPessoa.getTelefone());
            novaPessoa.setDataNascimento(oldPessoa.getDataNascimento());
            novaPessoa.setDataCadastro(oldPessoa.getDataCadastro());
            novaPessoa.setDataAlteracao(oldPessoa.getDataAlteracao());                          
            return novaPessoa;           
        }else{ 
            //Se não, retorna Pessoa
            return PessoaRepository.getPessoaPorId(idPessoa);
        }
    }
    
}
