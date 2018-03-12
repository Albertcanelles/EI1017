package uji.es.EI1017.crud;

import uji.es.EI1017.clases.Factura;
import uji.es.EI1017.clases.Llamada;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CrudFactura {
    ArrayList<Factura> facturas = new ArrayList<Factura>();
    HashMap<String, ArrayList<Factura>> listaFacturas = new HashMap<String, ArrayList<Factura>>();
    Calendar calendar = Calendar.getInstance();
    Scanner scanner = new Scanner(System.in);
    CrudLlamada crudLlamada = new CrudLlamada();  // Llamamos a los metodos de la clase CrudLlamada

    public Factura emitirFactura() {
        System.out.println("Introduce el DNI del cliente:");
        String DNI = scanner.next();
        System.out.println("Introduce el codigo de la factura:");
        int codigoFactura= scanner.nextInt();
        Date emisionFactura = calendar.getTime();
        System.out.println("Introduce el la fecha inicio dd/MM/yyyy");
        Date fechaInicial = null;
        try {
            fechaInicial = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Introduce el la fecha final dd/MM/yyyy");
        Date fechaFinal = null;
        try {
            fechaFinal = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        float duracion = crudLlamada.sumarMinutos(DNI, fechaInicial, fechaFinal);
        Factura factura = new Factura(codigoFactura, duracion, emisionFactura,fechaInicial, fechaFinal);
        facturas.add(factura);
        if(listaFacturas.containsKey(DNI)) {
            listaFacturas.replace(DNI, facturas, facturas);
        }
        else {
            listaFacturas.put(DNI, facturas);
        }
        return factura;
    }

    public String devolverDatosFacturaPorCodigo() {
        System.out.println("Introduce el codigo de la factura:");
        int codigoFactura= scanner.nextInt();
        for(int i = 0; i< listaFacturas.size();i++) {
            if(listaFacturas.get(i).equals(codigoFactura)) {
                return listaFacturas.get(i).toString();
            }
            else {
                return "No exite la factura";
            }
        }
        return null;
    }

    public ArrayList<Factura> recuperarTodasFacturas() {
        System.out.println("Introduce el DNI del cliente para listar sus facturas:");
        String DNI = scanner.next();
        ArrayList<Factura> facturasCliente = new ArrayList<Factura>();
        if(listaFacturas.containsKey(DNI)){
            for (HashMap.Entry entry : listaFacturas.entrySet()){
                if(entry.getKey().equals(DNI))
                    for(int i = 0; i<listaFacturas.entrySet().size(); i++) {
                        System.out.println(listaFacturas.entrySet().toString());
                    }
            }
        }else {
            System.err.println("No existe el cliente");
        }
        return facturasCliente;
    }
}
