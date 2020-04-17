/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ads.estoque.dominio;

import java.util.List;

/**
 *
 * @author Leonardo
 */
public class ValidarException extends Exception {
    //O atributo erros conterá a lista de mensagens de erro da exception
    private List<String> erros;
 //Quando instanciar a exception passar a lista de mensagens de erro
    public ValidarException(List<String> erros) {
        this.erros = erros;
    }
    //Retorna a lista de erros
    public List<String> getErros() {
        return erros;
    }
    //Retorna uma String com as mensagens de erro, uma em cada linha
    public String getMensagemErros() {
        String ret = "";
        for (String s : erros){
        ret += s+"\n";
    }
    return ret;
    }

}
