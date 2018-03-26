package uji.es.EI1017.Clases;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import java.util.Date;

public class Llamada {
    private int telefono;
    private Date fechaLlamada;
    private float duracion;

    public Llamada(int telefono, Date fechaLlamada, float duracion) {
        this.telefono = telefono;
        this.fechaLlamada = fechaLlamada;
        this.duracion = duracion;
    }

    public int getTelefono() {
        return telefono;
    }

    public Date getFecha() {
        return fechaLlamada;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setFechaLlamada(Date fechaLlamada) {
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
