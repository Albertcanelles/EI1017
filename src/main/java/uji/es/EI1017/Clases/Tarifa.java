package uji.es.EI1017.Clases;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
* Albert Cañelles Panisello
* Daniel Garcia Ruiz
*/
public class Tarifa implements Serializable {
    public float precio;

    public Tarifa(){
        this.precio = 0;
    }
    public Tarifa(float precio){
        this.precio = precio;
    }

    public float getPrecio(LocalDateTime fecha ) {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String toString(){
        return "tarifa: " + String.valueOf(precio);
    }


}
