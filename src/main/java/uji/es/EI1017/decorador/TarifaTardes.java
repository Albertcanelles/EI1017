package uji.es.EI1017.decorador;

import uji.es.EI1017.Clases.Tarifa;

public class TarifaTardes extends Tarifa {

    private Tarifa tarifa;

    public TarifaTardes(Tarifa tarifa) {
        super(5);
        this.tarifa=tarifa;
    }
    @Override
    public float getPrecio(){
        return tarifa.getPrecio() + super.getPrecio();
    }
}
