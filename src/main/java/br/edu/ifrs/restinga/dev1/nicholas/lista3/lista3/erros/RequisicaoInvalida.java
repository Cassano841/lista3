package br.edu.ifrs.restinga.dev1.nicholas.lista3.lista3.erros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequisicaoInvalida extends RuntimeException{
    public RequisicaoInvalida (String erro){
        super(erro);
    }
}
