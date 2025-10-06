package actividad1;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidosActivos;
    private List<Pedido> historialPedidos;
    
    public PedidoModelo() {
        pedidosActivos = new ArrayList<>();
        historialPedidos = new ArrayList<>();
    }
    
    public void agregarPedido(Pedido pedido) {
        pedidosActivos.add(pedido);
    }
    
    public boolean eliminarPedido(String nombre) {
        for (Pedido pedido : pedidosActivos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombre)) {
                pedido.setEstado(Pedido.EstadoPedido.ELIMINADO);
                historialPedidos.add(pedido);
                pedidosActivos.remove(pedido);
                return true;
            }
        }
        return false;
    }
    
    public boolean marcarComoCompletado(String nombre) {
        for (Pedido pedido : pedidosActivos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombre)) {
                pedido.setEstado(Pedido.EstadoPedido.COMPLETADO);
                historialPedidos.add(pedido);
                pedidosActivos.remove(pedido);
                return true;
            }
        }
        return false;
    }
    
    public void actualizarPedido(Pedido pedido, String nombre, String tipo) {
        pedido.setNombrePlato(nombre);
        pedido.setTipoPlato(tipo);
    }
    
    public List<Pedido> buscarPorNombre(String nombre) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidosActivos) {
            if (pedido.getNombrePlato().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }
    
    public List<Pedido> buscarPorTipo(String tipo) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidosActivos) {
            if (pedido.getTipoPlato().equalsIgnoreCase(tipo)) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }
    
    public List<Pedido> getPedidosPorEstado(Pedido.EstadoPedido estado) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidosActivos) {
            if (pedido.getEstado() == estado) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }
    
    public int contarTotalPedidos() {
        return pedidosActivos.size();
    }
    
    public int contarPedidosPorTipo(String tipo) {
        int count = 0;
        for (Pedido pedido : pedidosActivos) {
            if (pedido.getTipoPlato().equalsIgnoreCase(tipo)) {
                count++;
            }
        }
        return count;
    }
    
    public int contarPedidosPendientes() {
        int count = 0;
        for (Pedido pedido : pedidosActivos) {
            if (pedido.getEstado() == Pedido.EstadoPedido.PENDIENTE) {
                count++;
            }
        }
        return count;
    }
    
    public List<Pedido> getPedidosActivos() {
        return new ArrayList<>(pedidosActivos);
    }
    
    public List<Pedido> getHistorialPedidos() {
        return new ArrayList<>(historialPedidos);
    }
    
    public List<Pedido> getTodosLosPedidos() {
        List<Pedido> todos = new ArrayList<>();
        todos.addAll(pedidosActivos);
        todos.addAll(historialPedidos);
        return todos;
    }
}