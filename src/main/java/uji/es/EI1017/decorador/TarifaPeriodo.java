package uji.es.EI1017.decorador;

import uji.es.EI1017.Clases.Tarifa;

import java.time.LocalDateTime;

public class TarifaPeriodo extends Tarifa {

    private Tarifa tarifaPadre;
    private int horaIni;
    private int horaFin;

    public TarifaPeriodo(Tarifa tarifaPadre, float precio, int horaIni, int horaFin) {
        super(precio);
        this.tarifaPadre = tarifaPadre;
        this.horaIni = horaIni;
        this.horaFin = horaFin;
    }

    @Override
    public float getPrecio(LocalDateTime fecha) {
        float padre = tarifaPadre.getPrecio(fecha);
        float costeActual;
        if (fecha.getHour() >= horaIni && fecha.getHour() < horaFin) {
            costeActual = super.precio;

            if (padre < costeActual) {
                costeActual = padre;
            }
        } else {
            costeActual = padre;
        }
        return costeActual;
    }

    @Override
    public String toString() {
        return super.toString() + ", tarifa de periodo extra: " + String.valueOf(precio);
    }
}
