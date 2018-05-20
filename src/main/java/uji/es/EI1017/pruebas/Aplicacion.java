package uji.es.EI1017.pruebas;

import uji.es.EI1017.excepciones.ErrorEntreFechasException;
import uji.es.EI1017.excepciones.NoExisteClienteException;

import java.io.IOException;

public class Aplicacion {
    public static void main(String[] args) throws ErrorEntreFechasException, NoExisteClienteException {
        GuardadoDatos data = new GuardadoDatos();
        Ventana ventana = data.lectura();
        ventana.ventanaPrincipal();
    }
}
