package ejercicio2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestorPersonaje {
    private List<Personaje> lista = new ArrayList<>();

    public void cargarDesdeDB(Connection con) throws Exception {
        lista.clear();
        PreparedStatement select = con.prepareStatement("SELECT * FROM Personaje;");
        ResultSet rs = select.executeQuery();
        while (rs.next()) {
            Personaje p = new Personaje(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getInt("ataque"),
                rs.getInt("defensa")
            );
            lista.add(p);
        }
        rs.close();
        select.close();
    }

    public List<Personaje> consultar(
        String[] camposMostrar,
        String filtroCampo,
        String operador,
        String filtroValor,
        String ordenarPor,
        boolean descendente,
        int limite
    ) {
        List<Personaje> resultado = new ArrayList<>();
        for (Personaje p : lista) {
            if (cumpleFiltro(p, filtroCampo, operador, filtroValor)) {
                resultado.add(p);
            }
        }

        if (ordenarPor != null && !ordenarPor.trim().isEmpty()) {
            Comparator<Personaje> cmp = compararPor(ordenarPor);
            if (cmp != null) {
                resultado.sort(cmp);
                if (descendente) {
                    java.util.Collections.reverse(resultado);
                }
            }
        }

        if (limite > 0 && resultado.size() > limite) {
            return new ArrayList<>(resultado.subList(0, limite));
        }

        return resultado;
    }

    private boolean cumpleFiltro(Personaje p, String campo, String operador, String valor) {
        if (campo == null || campo.trim().isEmpty() || operador == null || valor == null) return true;
        Object campoValObj = p.getCampo(campo);
        if (campoValObj == null) return true;

        if (campo.equalsIgnoreCase("id") || campo.equalsIgnoreCase("ataque") || campo.equalsIgnoreCase("defensa")) {
            try {
                double vRegistro = Double.parseDouble(campoValObj.toString());
                double vFiltro = Double.parseDouble(valor);
                switch (operador) {
                    case "=": return vRegistro == vFiltro;
                    case "!=": return vRegistro != vFiltro;
                    case ">": return vRegistro > vFiltro;
                    case "<": return vRegistro < vFiltro;
                    case ">=": return vRegistro >= vFiltro;
                    case "<=": return vRegistro <= vFiltro;
                }
            } catch (NumberFormatException ex) {
                return false;
            }
        } else {
            String reg = campoValObj.toString();
            switch (operador.toUpperCase()) {
                case "=": return reg.equals(valor);
                case "!=": return !reg.equals(valor);
                case "LIKE": return reg.toLowerCase().contains(valor.toLowerCase());
                default: return false;
            }
        }
        return false;
    }

    private Comparator<Personaje> compararPor(String campo) {
        switch (campo.toLowerCase()) {
            case "id":
                return Comparator.comparingInt(a -> a.id);
            case "nombre":
                return Comparator.comparing(a -> a.nombre.toLowerCase());
            case "ataque":
                return Comparator.comparingInt(a -> a.ataque);
            case "defensa":
                return Comparator.comparingInt(a -> a.defensa);
            default:
                return null;
        }
    }

    public void imprimirResultados(List<Personaje> resultados, String[] camposMostrar) {
        boolean todos = (camposMostrar == null || camposMostrar.length == 0);
        for (Personaje p : resultados) {
            if (todos) {
                System.out.println(p.toString());
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < camposMostrar.length; i++) {
                    String c = camposMostrar[i].trim();
                    Object val = p.getCampo(c);
                    sb.append(val == null ? "NULL" : val.toString());
                    if (i < camposMostrar.length - 1) sb.append(" ");
                }
                System.out.println(sb.toString());
            }
        }
        if (resultados.isEmpty()) System.out.println("No hay registros que cumplan la consulta.");
    }
}