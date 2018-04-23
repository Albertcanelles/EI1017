package uji.es.EI1017.factoria;

import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Tarifa;
import uji.es.EI1017.decorador.TarifaBasica;
import uji.es.EI1017.decorador.TarifaDomingos;
import uji.es.EI1017.decorador.TarifaTardes;

public interface IFabrica {

    public Cliente getParticular(String apellido);

    public Cliente getEmpresa();

    public Tarifa getTarifaBasica(float precio);

    public TarifaTardes getTarifaTardes(Tarifa tarifa, float precio);

    public TarifaDomingos getTarifaDomingo(Tarifa tarifa, float precio);
}
