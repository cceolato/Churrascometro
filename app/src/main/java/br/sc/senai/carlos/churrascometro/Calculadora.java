package br.sc.senai.carlos.churrascometro;

/**
 * Created by CarlosAlberto on 14/09/2015.
 */
public class Calculadora {

    public String calculaCarne(int carne, int pessoas){
        int valor = (carne * pessoas);
        return String.valueOf(valor);
    }

    public String calculaLinguica(int linguica, int pessoas){
        int valor = (linguica * pessoas);
        return String.valueOf(valor);
    }

    public String calculaRefri(int refri, int pessoas){
        int valor = (refri * pessoas);
        return String.valueOf(valor);
    }
}
