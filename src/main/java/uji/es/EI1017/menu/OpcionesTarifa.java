package uji.es.EI1017.menu;

public enum OpcionesTarifa {
    TARIFA_POR_HORAS("Tarifa especial por horas"),
    TARIFA_POR_DIAS("Tarifa especial por dias. "),
    NO_GRACIAS("Ahora no gracias");

    private String descripcion;

    private OpcionesTarifa(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public static OpcionesTarifa getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for(OpcionesTarifa opcion: OpcionesTarifa.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
