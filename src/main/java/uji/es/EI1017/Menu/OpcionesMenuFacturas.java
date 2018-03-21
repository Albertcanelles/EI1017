package uji.es.EI1017.Menu;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
public enum OpcionesMenuFacturas {
    EMITIR_FACTURA_PARA_CLIENTE("Selecciona el cliente para emitir su factura"),
    RECUPERAR_DATOS_FACTURA_POR_CODIGO("Introduce el codigo de la factura a recuperar"),
    LISTAR_FACTURAS_ENTRE_FECHAS("Mostrar facturas emitidas entre dos fechas. "),
    RECUPERAR_TODAS_FACTUAS_CLIENTE("Introduce el nombre del cliente para recibir sus facturas");

    private String descripcion;

    private OpcionesMenuFacturas(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public static OpcionesMenuFacturas getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for(OpcionesMenuFacturas opcion: OpcionesMenuFacturas.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
