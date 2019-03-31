package br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.modelo.entidade;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date retirada;
    private Date previsaoDevolucao;
    private Date devolucao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRetirada() {
        return retirada;
    }

    public void setRetirada(Date retirada) {
        this.retirada = retirada;
    }

    public Date getPrevisaoDevolucao() {
        return previsaoDevolucao;
    }

    public void setPrevisaoDevolucao(Date previsaoDevolucao) {
        this.previsaoDevolucao = previsaoDevolucao;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }
    
    
}
