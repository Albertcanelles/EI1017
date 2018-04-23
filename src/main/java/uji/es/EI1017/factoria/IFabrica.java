package uji.es.EI1017.factoria;

import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Tarifa;
import uji.es.EI1017.decorador.TarifaBasica;
import uji.es.EI1017.decorador.TarifaDomingos;
import uji.es.EI1017.decorador.TarifaTardes;

public interface IFabrica {

     Cliente getParticular(String apellido);

     Cliente getEmpresa();

     Tarifa getTarifaBasica(float precio);

     TarifaTardes getTarifaTardes(Tarifa tarifa, float precio);

     TarifaDomingos getTarifaDomingo(Tarifa tarifa, float precio);
}
