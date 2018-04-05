package uji.es.EI1017.crud;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


import uji.es.EI1017.Clases.Fecha;

public class CrudGenerico {
    public static <T extends Fecha> Collection<T> extraerConjunto(Collection<T> coleccion, LocalDateTime fechaIni, LocalDateTime fechaFin) {
        Collection<T> extraccion = new ArrayList<T>();
        for(T iter : coleccion){
            if(iter.getFecha().compareTo(fechaIni)>=0 && iter.getFecha().compareTo(fechaFin)<=0){
                extraccion.add(iter);
            }
        }

        return extraccion;
    }
}
