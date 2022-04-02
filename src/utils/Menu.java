
package utils;

import java.util.Scanner;
import static presenter.Atualizar.atualizar;
import static presenter.Cadastrar.cadastrar;
import static presenter.Mostrar.mostrar;
import static presenter.Remover.remover;

/**
 *
 * @author Rodrigo Vieira
 */
public class Menu {
    
    public static void menuPrincipal() {
        System.out.println("SISTEMA CRUD PESSOA/ALUNO");
        System.out.println("1 - Criar pessoa ou aluno");
        System.out.println("2 - Mostrar todas as pessoas e alunos");
        System.out.println("3 - Atualizar dados de uma pessoa ou aluno");
        System.out.println("4 - Deletar uma pessoa ou aluno");
        System.out.println("0 - Para sair");  
    }
    
    public static void limparTela() {
        System.out.print("\n");
    }

    public static void executaOpcao(int opcao, Scanner sc) {
        
        switch(opcao){
            case 0:
                System.out.println("\nEncerrando...");
                //Thread.sleep(1000);
                break;
            case 1:
                cadastrar(); 
                break;
            case 2:
                mostrar();  
                break;
            case 3:
                atualizar();
                break;
            case 4:
                remover();
                break;      
            default: 
                System.out.println("\nOpcão inválida, tente novamente.");
                limparTela();               
        }
    }  
}
