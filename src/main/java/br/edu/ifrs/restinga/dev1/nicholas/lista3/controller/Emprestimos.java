package br.edu.ifrs.restinga.dev1.nicholas.lista3.controller;

import br.edu.ifrs.restinga.dev1.nicholas.lista3.erros.NaoEncontrado;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.erros.RequisicaoInvalida;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.dao.EmprestimoDAO;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.dao.LivroDAO;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.dao.UsuarioDAO;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.entidade.Emprestimo;
import br.edu.ifrs.restinga.dev1.nicholas.lista3.modelo.entidade.Livro;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Emprestimos {
    
    @Autowired
    EmprestimoDAO emprestimoDAO;
    
    @Autowired
    LivroDAO livroDAO;
    
    @Autowired
    UsuarioDAO usuarioDAO;
        
      
    @RequestMapping(path = "/emprestimos/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Emprestimo> listar() {
        return emprestimoDAO.findAll();        
    }
    
    @RequestMapping(path = "/emprestimos/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Emprestimo buscar(@PathVariable int id) {
        final Optional<Emprestimo> findById = emprestimoDAO.findById(id);
        if (findById.isPresent()) {
            return findById.get();
        } else {
            throw new NaoEncontrado("ID não encontrada!");
        }
    }
    
    @RequestMapping(path = "/emprestimos/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagar(@PathVariable int id) {
        if (emprestimoDAO.existsById(id)) {
            emprestimoDAO.deleteById(id);
        } else {
            throw new NaoEncontrado("ID não encontrada!");
        }
    }
    
    @RequestMapping(path = "/emprestimos/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Emprestimo cadastrar(@RequestBody Emprestimo emprestimo) {
        emprestimo.setId(0);
        Emprestimo emprestimoBanco = emprestimoDAO.save(emprestimo);
        return emprestimoBanco;
    }
    
    @RequestMapping(path = "/emprestimos/{id}/", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody Emprestimo emprestimo){
        final Emprestimo emprestimoBanco = this.buscar(id);
        
        emprestimoBanco.setBibliotecario(emprestimo.getBibliotecario());
        emprestimoBanco.setDevolucao(emprestimo.getDevolucao());
        emprestimoBanco.setRetirada(emprestimo.getRetirada());
        emprestimoBanco.setPrevisaoDevolucao(emprestimo.getPrevisaoDevolucao());
        
        emprestimoDAO.save(emprestimoBanco);
    }
    
    @RequestMapping(path = "/emprestimos/{idEmprestimo}/livros/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Livro cadastrarLivro(@PathVariable int idEmprestimo, @RequestBody Livro livro){
        Emprestimo emprestimoBanco = this.buscar(idEmprestimo);
        livro.setId(0);
        Livro livroBanco = livroDAO.save(livro);
        emprestimoBanco.getLivros().add(livroBanco);
        emprestimoDAO.save(emprestimoBanco);
        return livroBanco;
    }
    
    @RequestMapping(path = "/emprestimos/{idEmprestimo}/livros/", method = RequestMethod.GET) 
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> listarLivro(@PathVariable int idEmprestimo){
        return this.buscar(idEmprestimo).getLivros();
    }
    /*
    @RequestMapping(path = "/emprestimos/{idEmprestimo}/livros/{idLivro}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarLivros(@PathVariable int id, @RequestBody Livro livro){
        final Livro livroBanco = this.buscar(id);
        
        livroBanco.setAutor(livro.getAutor());
        
    }
    */
    
    /* Pesquisar */ 
    
    
    
}
