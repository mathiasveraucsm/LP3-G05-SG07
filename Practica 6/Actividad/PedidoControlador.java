package actividad1;

import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;
    
    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void agregarPedido(String nombrePlato, String tipoPlato) {
        if (!nombrePlato.isEmpty() && !tipoPlato.isEmpty()) {
            modelo.agregarPedido(new Pedido(nombrePlato, tipoPlato));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (" + tipoPlato + ")");
        } else {
            vista.mostrarMensaje("El nombre y tipo del plato no pueden estar vacíos.");
        }
    }
    
    public void mostrarPedidosActivos() {
        List<Pedido> pedidos = modelo.getPedidosActivos();
        vista.mostrarPedidos(pedidos);
    }
    
    public void eliminarPedido() {
        String nombre = vista.solicitarNombreParaEliminar();
        if (modelo.eliminarPedido(nombre)) {
            vista.mostrarMensaje("Pedido eliminado: " + nombre);
        } else {
            vista.mostrarMensaje("No se encontró el pedido: " + nombre);
        }
    }
    
    public void actualizarPedido() {
        mostrarPedidosActivos();
        int numero = vista.solicitarNumeroPedido();
        List<Pedido> pedidos = modelo.getPedidosActivos();
        
        if (numero > 0 && numero <= pedidos.size()) {
            Pedido pedido = pedidos.get(numero - 1);
            String nuevoNombre = vista.solicitarNombrePlato();
            String nuevoTipo = vista.solicitarTipoPlato();
            modelo.actualizarPedido(pedido, nuevoNombre, nuevoTipo);
            vista.mostrarMensaje("Pedido actualizado: " + nuevoNombre + " (" + nuevoTipo + ")");
        } else {
            vista.mostrarMensaje("Número de pedido inválido.");
        }
    }
    
    public void buscarPorNombre() {
        String nombre = vista.solicitarNombreParaBuscar();
        List<Pedido> resultados = modelo.buscarPorNombre(nombre);
        if (resultados.isEmpty()) {
            vista.mostrarMensaje("No se encontraron pedidos con ese nombre.");
        } else {
            vista.mostrarMensaje("Resultados de la búsqueda:");
            vista.mostrarPedidos(resultados);
        }
    }
    
    public void buscarPorTipo() {
        String tipo = vista.solicitarTipoParaBuscar();
        List<Pedido> resultados = modelo.buscarPorTipo(tipo);
        if (resultados.isEmpty()) {
            vista.mostrarMensaje("No se encontraron pedidos de ese tipo.");
        } else {
            vista.mostrarMensaje("Pedidos del tipo '" + tipo + "':");
            vista.mostrarPedidos(resultados);
        }
    }
    
    public void contarPedidos() {
        int total = modelo.contarTotalPedidos();
        int pendientes = modelo.contarPedidosPendientes();
        
        vista.mostrarMensaje("Total de pedidos activos: " + total);
        vista.mostrarMensaje("Pedidos pendientes: " + pendientes);
        
        // Contar por tipos únicos
        List<Pedido> pedidos = modelo.getPedidosActivos();
        java.util.Set<String> tipos = new java.util.HashSet<>();
        for (Pedido pedido : pedidos) {
            tipos.add(pedido.getTipoPlato());
        }
        
        for (String tipo : tipos) {
            int count = modelo.contarPedidosPorTipo(tipo);
            vista.mostrarMensaje(" - " + tipo + ": " + count + " pedidos");
        }
    }
    
    public void marcarComoCompletado() {
        String nombre = vista.solicitarNombreParaCompletar();
        if (modelo.marcarComoCompletado(nombre)) {
            vista.mostrarMensaje("Pedido marcado como completo: " + nombre);
        } else {
            vista.mostrarMensaje("No se encontró el pedido: " + nombre);
        }
    }
    
    public void mostrarPedidosPendientes() {
        List<Pedido> pendientes = modelo.getPedidosPorEstado(Pedido.EstadoPedido.PENDIENTE);
        if (pendientes.isEmpty()) {
            vista.mostrarMensaje("No hay pedidos pendientes.");
        } else {
            vista.mostrarMensaje("Pedidos Pendientes:");
            vista.mostrarPedidos(pendientes);
        }
    }
    
    public void mostrarHistorial() {
        List<Pedido> historial = modelo.getHistorialPedidos();
        if (historial.isEmpty()) {
            vista.mostrarMensaje("El historial de pedidos está vacío.");
        } else {
            vista.mostrarMensaje("Historial de Pedidos (Completados/Eliminados):");
            vista.mostrarPedidos(historial);
        }
    }
    
    public void mostrarContadorPendientes() {
        int pendientes = modelo.contarPedidosPendientes();
        vista.mostrarMensaje("Pedidos pendientes: " + pendientes);
    }
    
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    String tipoPlato = vista.solicitarTipoPlato();
                    agregarPedido(nombrePlato, tipoPlato);
                    break;
                case "2":
                    mostrarPedidosActivos();
                    break;
                case "3":
                    eliminarPedido();
                    break;
                case "4":
                    actualizarPedido();
                    break;
                case "5":
                    buscarPorNombre();
                    break;
                case "6":
                    buscarPorTipo();
                    break;
                case "7":
                    contarPedidos();
                    break;
                case "8":
                    marcarComoCompletado();
                    break;
                case "9":
                    mostrarPedidosPendientes();
                    break;
                case "10":
                    mostrarHistorial();
                    break;
                case "11":
                    mostrarContadorPendientes();
                    break;
                case "12":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("12"));
        vista.cerrarScanner();
    }
}
