package uji.es.EI1017.Clases;

import java.io.Serializable;

/*
* Albert Cañelles Panisello
* Daniel Garcia Ruiz
*/
public abstract class Tarifa implements Serializable {
    private float precio;

    public Tarifa(float precio){
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

}
