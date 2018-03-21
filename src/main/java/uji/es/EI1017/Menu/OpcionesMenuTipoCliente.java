package uji.es.EI1017.Menu;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
public enum OpcionesMenuTipoCliente {
    PARTICULAR("El cliente es un particular?"),
    EMPRESA("El cliente es una empresa?");

    private String descripcion;

    private OpcionesMenuTipoCliente(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static OpcionesMenuTipoCliente getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for(OpcionesMenuTipoCliente opcion: OpcionesMenuTipoCliente.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
