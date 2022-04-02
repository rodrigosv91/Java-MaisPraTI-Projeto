
package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;
import java.util.regex.Pattern;
import static utils.Menu.menuPrincipal;

/**
 *
 * @author Rodrigo Vieira
 */
public class Reader {
    
    public static String validaDataNascimento(Scanner sc){          
        boolean testaPattern =  true;
        boolean testaIsAfter = true;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        
        String data = sc.nextLine();
 
        while(testaPattern || testaIsAfter ){
            testaPattern = true;
            testaIsAfter = true;
            try {
                // test to check if data has a valid format
                while(!Pattern.matches("^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/]\\d\\d\\d\\d$", data)){
                    System.out.println("\nData inválida.");
                    System.out.println("Informe a data de nascimento [Formato: dd/mm/aaaa]:"); 
                    data = sc.nextLine();
                }
                testaPattern = false;    
                // Parse test to avoid year 31/02/2000 as valid
                LocalDate parsedData = LocalDate.parse(data, format.withResolverStyle(ResolverStyle.STRICT)); 
                testaIsAfter = parsedData.isAfter(LocalDate.now());
                
                if(testaIsAfter){
                    //testaIsAfter = true;
                    System.out.println("\nData futura inválida.");
                    System.out.println("Informe a data de nascimento [Formato: dd/mm/aaaa]:"); 
                    data = sc.nextLine();
                }                
                
            } catch (DateTimeParseException e) {
                System.out.println("\nData inválida.");
                System.out.println("Informe a data de nascimento [Formato: dd/mm/aaaa]:"); 
                data = sc.nextLine();
                testaIsAfter = true;
            }
        }
        return data;                   
    }
    
    public static String  validaNome(Scanner sc){
        String entrada = sc.nextLine(); 
        // Nome com somente letras e ao menos uma
        while(!Pattern.matches("^\\D{1,}$", entrada)){
            System.out.println("\nNome inválido [Somente letras e ao menos uma].");
            System.out.println("Informe o nome novamente:"); 
            entrada = sc.nextLine();
       }
       return entrada;
    }
    
    //Valida telefone com Regex
    public static String  validaTelefone(Scanner sc){
        String entrada = sc.nextLine(); 
        //Telefone com pelo menos um digito            
        while(!Pattern.matches(".*\\d+.*", entrada)){
        //Alternative while Patter 
        //while(!Pattern.compile("\\d").matcher(entrada).find()){    
            System.out.println("\nTelefone inválido [Precisa ao menos um número].");
            System.out.println("Informe o telefone novamente:"); 
            entrada = sc.nextLine();
       }
       return entrada;
    }
    
    //Valida telefone com metodo String: charAt
    public static String  validaTelefone_2(Scanner sc){
        boolean check = true;
        String entrada = sc.nextLine(); 
        while(check){	
            int count=0;
            int i;
            for(i = 0; i<entrada.length(); i++){
		if(entrada.charAt(i) >= '0' && entrada.charAt(i) <= '9'){
		    count++;
                    break;
		}
            }
            if(count>=1){
                check = false;
            }
            else{
                System.out.println("\nTelefone inválido [Precisa ao menos um número].");
                System.out.println("Informe o telefone novamente:"); 
                entrada = sc.nextLine();
            }
        }   
       return entrada;
    }
              
    public static int validaInteiroMenu(Scanner sc){        
        while(!sc.hasNextInt()){
            System.out.println("\nEntrada inválida, tente novamente.");
            Menu.limparTela();
            menuPrincipal();
            sc.nextLine();
        }
        return sc.nextInt();
    }
    
    public static int validaInteiroAtualizar(Scanner sc){        
        while(!sc.hasNextInt()){
            System.out.println("\nEntrada inválida.");
            System.out.println("Informe o número de identificação da pessoa ou aluno a ser atualizado:");
            sc.nextLine();
        }
        return sc.nextInt();
    }
    
    public static int validaInteiroRemover(Scanner sc){        
        while(!sc.hasNextInt()){
            System.out.println("\nEntrada inválida.");
            System.out.println("Informe o número de identificação da pessoa ou aluno a ser removido:"); 
            sc.nextLine();
        }
        return sc.nextInt();
    }    
}
