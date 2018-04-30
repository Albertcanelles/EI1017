package uji.es.EI1017.factoria;

import uji.es.EI1017.Clases.Tarifa;
import uji.es.EI1017.decorador.TarifaBasica;
import uji.es.EI1017.decorador.TarifaDia;
import uji.es.EI1017.decorador.TarifaPeriodo;

public class FabricaTarifas {
    private TarifaBasica basica;
    private TarifaDia dia;
    private TarifaPeriodo periodo;

    public TarifaBasica getBasica(float precio){
        basica = new TarifaBasica(precio);
        return basica;
    }
    public TarifaDia getDia(Tarifa tarifaPadre, float precio, int diaSemana){
        dia = new TarifaDia(tarifaPadre,precio,diaSemana);
        return dia;
    }
    public TarifaPeriodo getPeriodo(Tarifa tarifaPadre, float precio, int horaIni, int horaFin){
        periodo = new TarifaPeriodo(tarifaPadre, precio, horaIni, horaFin);
        return periodo;
    }
}

