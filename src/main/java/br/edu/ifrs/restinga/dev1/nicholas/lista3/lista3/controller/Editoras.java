package br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.controller;

import br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.modelo.dao.EditoraDAO;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.modelo.entidade.Editora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Editoras {
    
    @Autowired
    EditoraDAO editoraDAO;
    
    @RequestMapping(path="/editoras/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Editora> listar(){
        return editoraDAO.findAll();
    }
 
}
