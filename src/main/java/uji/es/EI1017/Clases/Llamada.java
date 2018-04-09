package uji.es.EI1017.Clases;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import java.io.Serializable;
import java.time.LocalDateTime;

public class Llamada implements Fecha, Serializable{
    private int telefono;
    private LocalDateTime fechaLlamada;
    private float duracion;

    public Llamada(int telefono, LocalDateTime fechaLlamada, float duracion) {
        this.telefono = telefono;
        this.fechaLlamada = fechaLlamada;
        this.duracion = duracion;
    }


    public int getTelefono() {
        return telefono;
    }

    public LocalDateTime getFecha() {
        return fechaLlamada;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setFechaLlamada(LocalDateTime fechaLlamada) {
        this.fechaLlamada = fechaLlamada;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Llamada{" +
                "telefono=" + telefono +
                ", fechaLlamada=" + fechaLlamada +
                ", duracion=" + duracion +
                '}';
    }
}
