package uji.es.EI1017.factoria;

import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Tarifa;
import uji.es.EI1017.decorador.TarifaBasica;
import uji.es.EI1017.decorador.TarifaDomingos;
import uji.es.EI1017.decorador.TarifaTardes;
import uji.es.EI1017.herencias.Empresa;
import uji.es.EI1017.herencias.Particular;

public class Fabrica implements IFabrica {
    @Override
    public Cliente getParticular(String apellido) {
        Cliente particular = new Particular();
        ((Particular) particular).setApellidos(apellido);
        particular.setTarifa(getTarifaBasica(0.15f));
        return particular;
    }

    @Override
    public Cliente getEmpresa() {
        Cliente empresa = new Empresa();
        empresa.setTarifa(getTarifaBasica(0.15f));
        return empresa;
    }

    @Override
    public Tarifa getTarifaBasica(float precio) {
        return new Tarifa(precio);
    }


    @Override
    public TarifaTardes getTarifaTardes(Tarifa tarifa, float precio) {
        return new TarifaTardes(tarifa,precio);
    }

    @Override
    public TarifaDomingos getTarifaDomingo(Tarifa tarifa, float precio) {
        return new TarifaDomingos(tarifa,precio);
    }
}
