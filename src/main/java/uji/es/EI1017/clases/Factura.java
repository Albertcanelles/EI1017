package uji.es.EI1017.clases;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import java.util.Date;

public class Factura {
    private int codigo;
    private double minutos;
    private Date emisionFactura;
    private Date fechaFinal;
    private Date fechaInicial;

    public Factura(int codigo, double minutos, Date emisionFactura, Date fechaFinal, Date fechaInicial) {
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

    public Date getFecha() {
        return emisionFactura;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    public void setEmisionFactura(Date emisionFactura) {
        this.emisionFactura = emisionFactura;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setFechaInicial(Date fechaInicial) {
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
