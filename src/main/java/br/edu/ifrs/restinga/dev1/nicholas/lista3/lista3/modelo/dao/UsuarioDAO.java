package br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.modelo.dao;

import br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.modelo.entidade.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
    
}
