package uji.es.EI1017.excepciones;

public class ErrorEntreFechasException extends Exception{
    public ErrorEntreFechasException(){
        super("El periodo de entre fechas es incorrecto");
    }

}
