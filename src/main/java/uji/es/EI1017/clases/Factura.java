package uji.es.EI1017.clases;

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

    public Date getEmisionFactura() {
        return emisionFactura;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }
}
