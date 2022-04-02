
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Rodrigo Vieira
 */
public class Aluno extends Pessoa{
    
    protected double notaFinal;

    public Aluno() {
    }

    public Aluno(int id, String nome, String telefone, LocalDate dataNascimento, LocalDateTime dataCadastro, LocalDateTime dataAlteracao, double notaFinal) {
        super(id, nome, telefone, dataNascimento, dataCadastro, dataAlteracao);
        this.notaFinal = notaFinal;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
    
}
