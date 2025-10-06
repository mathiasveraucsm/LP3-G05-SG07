package actividad1;

public class Pedido {
    private String nombrePlato;
    private String tipoPlato;
    private EstadoPedido estado;
    private java.time.LocalDateTime fechaCreacion;
    private java.time.LocalDateTime fechaCompletado;
    
    public enum EstadoPedido {
        PENDIENTE, COMPLETADO, ELIMINADO
    }
    
    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
        this.estado = EstadoPedido.PENDIENTE;
        this.fechaCreacion = java.time.LocalDateTime.now();
    }
    
    public String getNombrePlato() { return nombrePlato; }
    public void setNombrePlato(String nombrePlato) { this.nombrePlato = nombrePlato; }
    
    public String getTipoPlato() { return tipoPlato; }
    public void setTipoPlato(String tipoPlato) { this.tipoPlato = tipoPlato; }
    
    public EstadoPedido getEstado() { return estado; }
    public void setEstado(EstadoPedido estado) { 
        this.estado = estado;
        if (estado == EstadoPedido.COMPLETADO) {
            this.fechaCompletado = java.time.LocalDateTime.now();
        }
    }
    
    public java.time.LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public java.time.LocalDateTime getFechaCompletado() { return fechaCompletado; }
    
    @Override
    public String toString() {
        String estadoStr = "";
        switch (estado) {
            case PENDIENTE: estadoStr = "[PENDIENTE]"; break;
            case COMPLETADO: estadoStr = "[COMPLETADO]"; break;
            case ELIMINADO: estadoStr = "[ELIMINADO]"; break;
        }
        return estadoStr + " " + nombrePlato + " (" + tipoPlato + ")";
    }
}