package br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.dao;

import br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.entidade.Bibliotecario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecarioDAO extends CrudRepository<Bibliotecario, Integer>{
    
}

