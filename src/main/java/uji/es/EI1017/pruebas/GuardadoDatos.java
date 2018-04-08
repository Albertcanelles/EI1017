package uji.es.EI1017.pruebas;
import java.io.*;

public class GuardadoDatos {
    public void escritura(Ejecutar eje) throws IOException {
        try {
            File fich = new File("Datos.obj");
            if (fich.createNewFile())
                System.out.println("no existia, se ha creado el fichero");

            FileOutputStream fout = new FileOutputStream(fich);
            ObjectOutputStream oout = new ObjectOutputStream(fout);

            oout.writeObject(eje);

            oout.close();
        }catch (FileNotFoundException e) {
            System.out.println("error no fichero");
        }catch (IOException e){
            System.out.println("error no escritura");
        }
    }

    public Ejecutar lectura(){
        ObjectInputStream oois = null;
        Ejecutar eje = new Ejecutar();

        try{

            File fich = new File("Datos.obj");
            FileInputStream ffis = new FileInputStream(fich);
            oois = new ObjectInputStream(ffis);


            eje = (Ejecutar) oois.readObject();
            System.out.println("Fichero leido de forma correcta.");

        } catch(FileNotFoundException e){
            System.out.println("file exception");
        } catch(IOException e){
            System.out.println("Io exception");
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            System.out.println("Class exception");
        }

        //oois.close();
        return eje;
    }
}

