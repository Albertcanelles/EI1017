package uji.es.EI1017.decorador;

import uji.es.EI1017.Clases.Tarifa;

public class TarifaDomingos extends Tarifa {

    private Tarifa tarifa;

    public TarifaDomingos(Tarifa tarifa, float precioTarifaDomingos) {
        super(precioTarifaDomingos);
        this.tarifa = tarifa;
    }
    @Override
    public float getPrecio(){
        return super.getPrecio();
    }
}
