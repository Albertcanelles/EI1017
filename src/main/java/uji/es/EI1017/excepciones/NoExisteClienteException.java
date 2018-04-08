package uji.es.EI1017.excepciones;

public class NoExisteClienteException extends Exception {
    public NoExisteClienteException(){
        super("El cliente no existe");
    }

}
