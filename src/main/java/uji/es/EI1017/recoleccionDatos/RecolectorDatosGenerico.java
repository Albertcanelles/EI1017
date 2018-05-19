package uji.es.EI1017.recoleccionDatos;

import uji.es.EI1017.excepciones.ErrorEntreFechasException;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RecolectorDatosGenerico {
    public static LocalDateTime pedirFecha(){
        int dia, mes, año, hora, min;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la fecha: (xx/xx/xxxx)");
        String fech = sc.nextLine();
        dia = Integer.parseInt(fech.substring(0,2));
        mes = Integer.parseInt(fech.substring(3,5));
        año = Integer.parseInt(fech.substring(6,10));

       hora = min = 0;
        LocalDateTime fecha = LocalDateTime.of(año, mes, dia, hora, min);
        return fecha;
    }
    public static LocalDateTime pedirFechaConHora(){
        int dia, mes, año, hora, min;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la fecha: (xx/xx/xxxx)");
        String fech = sc.nextLine();
        dia = Integer.parseInt(fech.substring(0,2));
        mes = Integer.parseInt(fech.substring(3,5));
        año = Integer.parseInt(fech.substring(6,10));

        System.out.println("¿Introducir hora?");
        String horaTrue =  sc.nextLine();
        if(horaTrue.equals("si")){
            System.out.println("Introduce la hora de la llamada: (xx:xx)");
            String f =  sc.nextLine();
            hora = Integer.parseInt(f.substring(0, 2));
            min = Integer.parseInt(f.substring(3, 5));
        }else{
            hora = min = 0;
        }
        hora = min = 0;
        LocalDateTime fecha = LocalDateTime.of(año, mes, dia, hora, min);
        return fecha;
    }
    public static boolean compruebaFecha(LocalDateTime ini, LocalDateTime fin) throws ErrorEntreFechasException{
        if(ini.isBefore(fin))
            return true;
        throw new ErrorEntreFechasException();
    }
}
