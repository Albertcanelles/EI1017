package uji.es.EI1017.decorador;

import uji.es.EI1017.Clases.Tarifa;

public class Juegos {
    public static void main(String[] args){
        float valor = 1.2f;
        float valor2 = 1.5f;
        Tarifa hola = new Tarifa(valor);
        hola = new TarifaTardes(hola,valor2);
        System.out.println(hola.getPrecio());
    }
}
