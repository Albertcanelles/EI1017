package uji.es.EI1017.menu;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
public enum OpcionesMenu   {
    GESTIONAR_CLIENTES("Gestion de los clientes."),
    GESTIONAR_LLAMADAS("Gestion de las llamadas."),
    GESTIONAR_FACTURAS("Gestion de las facturas."),
    SALIR("Salir del programa");

    private String descripcion;

    private OpcionesMenu(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static OpcionesMenu getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for(OpcionesMenu opcion: OpcionesMenu.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
