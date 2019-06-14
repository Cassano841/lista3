package br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.dao;

import br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.entidade.Telefone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TelefoneDAO extends CrudRepository<Telefone, Integer>{
    
}
