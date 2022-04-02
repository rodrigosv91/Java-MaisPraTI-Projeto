
package presenter; 

import static utils.Menu.limparTela;

/** 
 *
 * @author Rodrigo Vieira
 */
public class Mostrar {
    
    public static void mostrar(){ 
        controller.Mostrar m = new controller.Mostrar();
        m.mostrarTodos();
        limparTela();     
    }
}
