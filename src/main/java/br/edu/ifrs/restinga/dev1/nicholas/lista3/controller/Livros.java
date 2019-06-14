package br.edu.ifrs.restinga.dev1.nicholas.lista3.controller;

import br.edu.ifrs.restinga.dev1.nicholas.lista3.erros.NaoEncontrado;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.dao.LivroDAO;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.entidade.Livro;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Livros {
    
    @Autowired
    LivroDAO livroDAO;
    
    @RequestMapping(path = "/livros/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Livro> listar() {
        return livroDAO.findAll();        
    }
    
    @RequestMapping(path = "/livros/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Livro buscar(@PathVariable int id) {
        final Optional<Livro> findById = livroDAO.findById(id);
        if (findById.isPresent()) {
            return findById.get();
        } else {
            throw new NaoEncontrado("ID não encontrada!");
        }
    }
    
    @RequestMapping(path = "/livros/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagar(@PathVariable int id) {
        if (livroDAO.existsById(id)) {
            livroDAO.deleteById(id);
        } else {
            throw new NaoEncontrado("ID não encontrada!");
        }
    }
    
    @RequestMapping(path = "/livros/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Livro cadastrar(@RequestBody Livro livro) {
        livro.setId(0);
        Livro livroBanco = livroDAO.save(livro);
        return livroBanco;
    }
    
}
