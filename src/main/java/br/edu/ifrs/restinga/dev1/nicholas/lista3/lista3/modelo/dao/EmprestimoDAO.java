package br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.modelo.dao;

import br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.modelo.entidade.Emprestimo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoDAO extends CrudRepository<Emprestimo, Integer>{
    
}
