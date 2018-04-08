package uji.es.EI1017.Clases;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import java.io.Serializable;
import java.time.LocalDateTime;


public class Factura implements Fecha, Serializable {
    private int codigo;
    private double minutos;
    private LocalDateTime emisionFactura;
    private LocalDateTime fechaFinal;
    private LocalDateTime fechaInicial;

    public Factura(int codigo, double minutos, LocalDateTime emisionFactura, LocalDateTime fechaFinal, LocalDateTime fechaInicial) {
        this.codigo = codigo;
        this.minutos = minutos;
        this.emisionFactura = emisionFactura;
        this.fechaFinal = fechaFinal;
        this.fechaInicial = fechaInicial;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getMinutos() {
        return minutos;
    }

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

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

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
        return "Factura{" +
                "codigo=" + codigo +
                ", minutos=" + minutos +
                ", emisionFactura=" + emisionFactura +
                ", fechaFinal=" + fechaFinal +
                ", fechaInicial=" + fechaInicial +
                '}';
    }
}
