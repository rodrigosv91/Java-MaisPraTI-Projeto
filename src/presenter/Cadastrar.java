
package presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static utils.Menu.limparTela;
import static utils.Reader.validaDataNascimento;
import static utils.Reader.validaNome;
import static utils.Reader.validaTelefone;
import static utils.Reader.validaTelefone_2;

/**
 *
 * @author Rodrigo Vieira
 */
public class Cadastrar {
    
    public static void cadastrar() {
        Scanner sc = new Scanner(System.in);
        controller.Cadastrar ctrlCadastrar = new controller.Cadastrar();      
        boolean recebeuNota = false;
        double notaFinal = 0;
        
        limparTela();
        System.out.println("Informe o nome:"); 
        String nome = validaNome(sc);
        System.out.println("Informe o telefone:"); 
        String telefone = validaTelefone_2(sc); 
        System.out.println("Informe a data de nascimento [Formato: dd/mm/aaaa]:"); 
        String dataNascimento = validaDataNascimento(sc);  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate localDateNascimento = LocalDate.parse(dataNascimento, format);
            
        System.out.println("Informe a nota final [se necessário]:");
        
        try {            
            notaFinal = Double.valueOf(sc.nextLine().replace(',', '.'));
            recebeuNota = true;             
        }catch (NumberFormatException e){}
        
        if(recebeuNota){
            ctrlCadastrar.cadastrarAluno(nome, telefone, localDateNascimento, notaFinal);  
        }else{
            ctrlCadastrar.cadastrarPessoa(nome, telefone, localDateNascimento);
        }   
    }
}
