
package main;

import java.util.Scanner;
import utils.Menu;
import static utils.Reader.validaInteiroMenu;

/**
 *
 * @author Rodrigo Vieira
 */
public class Main { 
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        int opcao = 0;        
        do{          
            Menu.menuPrincipal();
            System.out.print("\nDigite a opção: "); 
            opcao = validaInteiroMenu(sc);                 
            Menu.executaOpcao(opcao, sc);              
        }while(opcao != 0);         
        sc.close();       
    }   
}
