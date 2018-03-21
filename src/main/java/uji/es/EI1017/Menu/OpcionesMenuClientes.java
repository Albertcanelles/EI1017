package uji.es.EI1017.Menu;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
public enum OpcionesMenuClientes  {
    DAR_DE_ALTA_CLIENTE("Dar de alta a un nuevo cliente."),
    BORRAR_CLIENTE("Eliminar un cliente."),
    CAMBIAR_TARIFA_CLIENTE("Cambiar tarifa de un cliente."),
    RECUPERAR_CLIENTE_POR_NIF("Seleccionar un cliente por su NIF."),
    LISTAR_CLIENTES_ENTRE_FECHAS("Mostrar clientes dado de alta entre dos fechas."),
    RECUPERAR_TODOS_CLIENTES("Seleccion de todos los clientes.");

    private String descripcion;

    private OpcionesMenuClientes(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static OpcionesMenuClientes getOpcion(int posicion) {
        return values()[posicion];
    }


    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for(OpcionesMenuClientes opcion: OpcionesMenuClientes.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
