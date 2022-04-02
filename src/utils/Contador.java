
package utils;

/**
 *
 * @author Rodrigo Vieira
 */
public class Contador {
    
    private static int contador = 0;
    
    public static int next (){
        contador++;
        return contador;
    } 
}
