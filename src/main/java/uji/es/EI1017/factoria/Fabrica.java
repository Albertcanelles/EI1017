package uji.es.EI1017.factoria;

import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Tarifa;
import uji.es.EI1017.decorador.TarifaBasica;
import uji.es.EI1017.decorador.TarifaDomingos;
import uji.es.EI1017.decorador.TarifaTardes;

public class Fabrica implements IFabrica {
    @Override
    public Cliente getParticular(String apellido) {
        return null;
    }

    @Override
    public Cliente getEmpresa() {
        return null;
    }

    @Override
    public Tarifa getTarifaBasica(float precio) {
        return null;
    }


    @Override
    public TarifaTardes getTarifaTardes(Tarifa tarifa, float precio) {
        return null;
    }

    @Override
    public TarifaDomingos getTarifaDomingo(Tarifa tarifa, float precio) {
        return null;
    }
}
