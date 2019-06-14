package br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.dao;

import br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.entidade.Emprestimo;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.entidade.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoDAO extends CrudRepository<Emprestimo, Integer>{
    List<Emprestimo> findByNomeContaining(String nome);
    List<Emprestimo> findByNomeStartingWith(String nome);
    List<Emprestimo> findByAnoBetween(float inicio, float fim);
    List<Emprestimo> findByUsuario(Usuario usuario);
    
}
