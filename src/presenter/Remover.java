
package presenter;

import java.util.Scanner;
import static utils.Menu.limparTela;
import static utils.Reader.validaInteiroRemover;

/**
 *
 * @author Rodrigo Vieira
 */
public class Remover {
    
    public static void remover() {
        controller.Remover ctrlRemover = new controller.Remover();
        
        if(!ctrlRemover.verificaSeVazia()){
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o número de identificação da pessoa ou aluno a ser removido:");       
            int id = validaInteiroRemover(sc);     
            ctrlRemover.removerPessoa(id);    
        }else{
            System.out.println("\nNão há pessoas ou alunos para remover.");
        }
        limparTela();
    }
}
