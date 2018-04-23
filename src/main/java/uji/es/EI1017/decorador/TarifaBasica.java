package uji.es.EI1017.decorador;

import uji.es.EI1017.Clases.Tarifa;

public  class TarifaBasica extends Tarifa {

    private Tarifa tarifa;


    public TarifaBasica(Tarifa tarifa, float precioTarifa) {
        super(precioTarifa);
        this.tarifa = tarifa;
    }
    @Override
    public float getPrecio(){
        return super.getPrecio();
    }

}
