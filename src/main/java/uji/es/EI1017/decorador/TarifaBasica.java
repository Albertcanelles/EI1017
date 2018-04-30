package uji.es.EI1017.decorador;

import uji.es.EI1017.Clases.Tarifa;

import java.time.LocalDateTime;

public  class TarifaBasica extends Tarifa {

    public TarifaBasica(){
        super();
    }
    public TarifaBasica (float precio){
        super(precio);
    }
    @Override
    public float getPrecio(LocalDateTime fecha){
        return precio;
    }

    @Override
    public String toString(){
        return super.toString();
    }


}
