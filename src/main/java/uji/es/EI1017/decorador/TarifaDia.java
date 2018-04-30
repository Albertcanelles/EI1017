package uji.es.EI1017.decorador;

import uji.es.EI1017.Clases.Tarifa;

import java.time.LocalDateTime;

public class TarifaDia extends TarifaBasica {

    private Tarifa tarifaPadre;
    private int dia;

    public TarifaDia(Tarifa tarifa, float precio, int dia) {
        super(precio);
        this.tarifaPadre = tarifa;
        this.dia = dia;
    }
    @Override
    public float getPrecio(LocalDateTime fecha){
        float padre = tarifaPadre.getPrecio(fecha);
        float costeActual;
        if(fecha.getDayOfWeek().equals(dia)){
            costeActual = super.precio;

            if(padre < costeActual){
                costeActual = padre;
            }
        }else{
            costeActual = padre;
        }
        return costeActual;
    }

    @Override
    public  String toString(){
        return super.toString() + ", tarifa de día extra: " + String.valueOf(precio);
    }
}