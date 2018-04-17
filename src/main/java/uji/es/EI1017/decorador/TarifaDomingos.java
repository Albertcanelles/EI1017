package uji.es.EI1017.decorador;

import uji.es.EI1017.Clases.Tarifa;

public class TarifaDomingos extends Tarifa {

    private Tarifa tarifa;

    public TarifaDomingos(Tarifa tarifa) {
        super(0);
        this.tarifa = tarifa;
    }
    @Override
    public float getPrecio(){
        return tarifa.getPrecio() + super.getPrecio();
    }
}
