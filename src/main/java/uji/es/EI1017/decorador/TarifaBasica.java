package uji.es.EI1017.decorador;

import uji.es.EI1017.Clases.Tarifa;

public class TarifaBasica extends Tarifa {

    private Tarifa tarifa;

    public TarifaBasica(Tarifa tarifa) {
        super(15);
        this.tarifa = tarifa;
    }
    @Override
    public float getPrecio(){
        return tarifa.getPrecio() + super.getPrecio();
    }

}
