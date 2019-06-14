package br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.entidade;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    private int anoPublicacao;
    private boolean doacao;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Editora> editora;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Autor> autor;

      
    public List<Editora> getEditora() {
        return editora;
    }

    public void setEditora(List<Editora> editora) {
        this.editora = editora;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDoacao() {
        return doacao;
    }

    public void setDoacao(boolean doacao) {
        this.doacao = doacao;
    }
    
    
}
