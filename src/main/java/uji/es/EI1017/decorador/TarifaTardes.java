package uji.es.EI1017.decorador;

import uji.es.EI1017.Clases.Tarifa;

public class TarifaTardes extends Tarifa {

    private Tarifa tarifa;

    public TarifaTardes(Tarifa tarifa, float precioTarifaTardes) {
        super(precioTarifaTardes);
        this.tarifa = tarifa;
    }
    @Override
    public float getPrecio(){
        return super.getPrecio();
    }
}
