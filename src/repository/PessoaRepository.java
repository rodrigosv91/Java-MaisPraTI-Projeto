
package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Pessoa;

/**
 *
 * @author Rodrigo
 */
public class PessoaRepository {
    
    public static HashMap<Integer, Pessoa> lista = new HashMap<Integer, Pessoa>();

    public static void inserir(Pessoa pessoa) {
        lista.put(pessoa.getId(), pessoa);
    }
    
    public static void remover(int chave) {
        lista.remove(chave);
    }
    
    public static void atualizar(Pessoa pessoa) {
        lista.replace(pessoa.getId(), pessoa);
    }
    
    public static ArrayList<Pessoa> getLista() {
        ArrayList<Pessoa> novaLista = new ArrayList<Pessoa>(lista.values());
        return novaLista;
        //return lista.values().stream().collect(Collectors.toList());       
    } 
    
    public static Pessoa getPessoaPorId(int id) {      
        return lista.get(id);
    }
}
