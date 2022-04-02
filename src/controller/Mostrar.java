
package controller;

import dao.PessoaDAO;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Aluno;
import model.Pessoa;
import static utils.Menu.limparTela;

/**
 *
 * @author Rodrigo Vieira
 */
public class Mostrar {
    
    public void mostrarTodos() {
        PessoaDAO dao = new PessoaDAO();
        ArrayList<Pessoa> lista = dao.buscarTodos();
        DateTimeFormatter fmtLD = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmtLDT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        if(!lista.isEmpty()){     
            String plural = lista.size()==1?"":"S";
            System.out.println("\nLISTA PESSOA"+ plural +"/ALUNO"+ plural ); 
            
            for(Pessoa p : lista){
                limparTela();
                System.out.println(String.format("| Identificação: %-5s  | Nome: %-5s | Telefone: %-5s | Data Nascimento: %-5s", p.getId(),  p.getNome(), p.getTelefone(), p.getDataNascimento().format(fmtLD)));
                System.out.println(String.format("| Data de cadastro: %-5s | Data ultima alteração: %-5s", p.getDataCadastro().format(fmtLDT), p.getDataAlteracao().format(fmtLDT) ));
                if(p instanceof Aluno){
                    Aluno a = (Aluno) p;
                    System.out.println(String.format("| Nota Final   : %.2f", a.getNotaFinal()));
                }
                System.out.println("------------------------------------------------------");
            }
        }
        else{
            System.out.println("\nNão há pessoas ou alunos para mostrar.");
        }
    }
}
