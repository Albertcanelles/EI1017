package uji.es.EI1017.menu;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
public enum OpcionesMenuLlamadas {
    DAR_DE_ALTA_UNA_LLAMADA("Introduce una llamada"),
    LISTAR_LLAMADAS_DE_UN_CLIENTE("Listado de todas las llamadas de un cliente"),
    LISTAR_LLAMADAS_ENTRE_FECHAS("Mostrar llamadas realizadas entre dos fechas."),
    ATRAS("Atras...");

    private String descripcion;

    private OpcionesMenuLlamadas(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static OpcionesMenuLlamadas getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for(OpcionesMenuLlamadas opcion: OpcionesMenuLlamadas.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }


}
