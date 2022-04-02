
package presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static utils.Menu.limparTela;
import static utils.Reader.validaDataNascimento;
import static utils.Reader.validaInteiroAtualizar;
import static utils.Reader.validaNome;
import static utils.Reader.validaTelefone;
import static utils.Reader.validaTelefone_2;

/**
 *
 * @author Rodrigo Vieira
 */
public class Atualizar {
    
    public static void atualizar() {       
        controller.Atualizar ctrlAtualizar = new controller.Atualizar(); 
        if(!ctrlAtualizar.verificaSeVazia()){
            Scanner sc = new Scanner(System.in);
            boolean recebeuNota = false;
            double notaFinal = 0;

            System.out.println("Informe o número de identificação da pessoa ou aluno a ser atualizado:"); 
            int id = validaInteiroAtualizar(sc);  
            sc.nextLine();

            if(ctrlAtualizar.verificaSeExiste(id)){
                System.out.println("Informe o nome:"); 
                String nome = validaNome(sc);
                System.out.println("Informe o telefone:"); 
                String telefone = validaTelefone_2(sc);
                System.out.println("Informe a data de nascimento [Formato: dd/mm/aaaa]:"); 
                String dataNascimento = validaDataNascimento(sc);  
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                LocalDate localDateNascimento = LocalDate.parse(dataNascimento, format);
               
                System.out.println("Informe a nota final:");

                try {           
                    notaFinal = Double.valueOf(sc.nextLine().replace(',', '.'));
                    recebeuNota = true;             
                }catch (NumberFormatException e){}

                if(recebeuNota){
                    ctrlAtualizar.atualizarAluno(id, nome, telefone, localDateNascimento, notaFinal);
                }else{
                    ctrlAtualizar.atualizarPessoa(id, nome, telefone, localDateNascimento);
                } 
            }else{
                System.out.println("\nNão há pessoa ou aluno com identificação: " + id);
                limparTela();
            }
        }else{
            System.out.println("\nNão há pessoas ou alunos para atualizar.");
            limparTela();
        }
    }
}
