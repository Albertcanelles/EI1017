package uji.es.EI1017.crud;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
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
        while ( DNI.length()!= 9){
            System.out.println("DNI invalido, ha de tener 8 números y una letra al final");
            System.out.println("Introduce el DNI del cliente:");
            DNI = scanner.next();
        }
        System.out.println("Introduce el codigo de la factura:");
        int codigoFactura= scanner.nextInt();
        while (codigoFactura<2){
            System.out.println("Código invalido, ha de ser un número de al menos 3 digitos");
            System.out.println("Introduce el codigo de la factura:");
            codigoFactura= scanner.nextInt();
        }
        Date emisionFactura = calendar.getTime();
        System.out.println("Introduce el la fecha inicio dd/MM/yyyy");
        String StrfechaInicio = scanner.nextLine();
        StrfechaInicio= scanner.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio  = null;
        String date = StrfechaInicio;
        try{
            fechaInicio  = df.parse(date);
        }catch (Exception e){
            System.out.println("Invalid format");
        }

        System.out.println("Introduce el la fecha final dd/MM/yyyy");
        String StrfechaFinal = scanner.nextLine();
        StrfechaFinal = scanner.nextLine();
        df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaFinal  = null;
        date = StrfechaFinal;
        try{
            fechaFinal  = df.parse(date);
        }catch (Exception e){
            System.out.println("Invalid format");
        }
        float duracion = crudLlamada.sumarMinutos(DNI, fechaInicio, fechaFinal);
        Factura factura = new Factura(codigoFactura, duracion, emisionFactura,fechaInicio, fechaFinal);
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
