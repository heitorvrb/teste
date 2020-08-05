package br.heitor.teste.jsf.bean;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author heitor
 */
@Named(value = "teste")
@Dependent
public class TesteBean {

    public TesteBean() {
    }

    public String texto() {
        return "este texto";
    }

}
