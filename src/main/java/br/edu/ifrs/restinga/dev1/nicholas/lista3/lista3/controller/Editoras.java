package br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.controller;

import br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.erros.NaoEncontrado;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.erros.RequisicaoInvalida;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.modelo.dao.EditoraDAO;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.modelo.entidade.Editora;
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
public class Editoras {
    
    @Autowired
    EditoraDAO editoraDAO;
    
    @RequestMapping(path="/editoras/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Editora> listar(){
        return editoraDAO.findAll();
    }
    
    @RequestMapping(path="/editoras/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Editora buscar(@PathVariable int id){
        final Optional<Editora> findByID = editoraDAO.findById(id);
        if (findByID.isPresent()){
            return findByID.get();
        } else {
            throw new NaoEncontrado("Id não encontrado!");
        }
    }
    
    @RequestMapping(path="/editora/{d}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagar(@PathVariable int id){
        if (editoraDAO.existsById(id)){
            editoraDAO.deleteById(id);
        } else {
            throw new NaoEncontrado("Id não encontrado!");
        }
    }
    
    @RequestMapping(path="/editoras/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody Editora editora){
        final Editora editoraBanco = this.buscar(id);
        
        editoraBanco.setNome(editora.getNome());
        editoraBanco.setCnpj(editora.getCnpj());
        
        editoraDAO.save(editoraBanco);
    }
    
    @RequestMapping(path="/editoras/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Editora Cadastrar(@RequestBody Editora editora){
        Editora editoraBanco = editoraDAO.save(editora);
        return editoraBanco;
    }
    
}
