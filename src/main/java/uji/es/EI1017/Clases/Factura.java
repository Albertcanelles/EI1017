package uji.es.EI1017.Clases;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import java.io.Serializable;
import java.time.LocalDateTime;


public class Factura implements Fecha, Serializable {
    private int codigo;
    private LocalDateTime emisionFactura;
    private LocalDateTime fechaFinal;
    private LocalDateTime fechaInicial;
    private float importe;
    public Factura() {

    }

    public Factura(int codigo,LocalDateTime emisionFactura,LocalDateTime fechaInicial, LocalDateTime fechaFinal, float importe) {
        this.codigo = codigo;
        this.importe = importe;
        this.emisionFactura = emisionFactura;
        this.fechaFinal = fechaFinal;
        this.fechaInicial = fechaInicial;
    }

    public int getCodigo() {
        return codigo;
    }

    public float getImporte() { return importe; }

    public LocalDateTime getFecha() {
        return emisionFactura;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setImporte(float importe){ this.importe = importe; }

    public void setEmisionFactura(LocalDateTime emisionFactura) {
        this.emisionFactura = emisionFactura;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setFechaInicial(LocalDateTime fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    @Override
    public String toString() {
        return "Factura { " +
                "codigo =" + codigo +
                ", emisionFactura =" + emisionFactura +
                ", fechaFinal =" + fechaFinal +
                ", fechaInicial =" + fechaInicial +
                "Precio = "+ importe + " }";
    }
}
