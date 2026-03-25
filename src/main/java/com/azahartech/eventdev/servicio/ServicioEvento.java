package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.datos.RepositorioGenerico;

import java.time.LocalDate;
import java.util.*;
import java.io.*;
import static com.azahartech.eventdev.presentacion.AppGUI.LogUtil;
/**
 * Clase ServicioEvento
 */
public class ServicioEvento {
    private RepositorioGenerico<Evento> repo = new RepositorioGenerico<>();
    private HashMap<String, Evento> mapaEventos = new HashMap<>();

    /**
     * Añadir un evento
     * @param nuevoEvento
     */
    public void registrarEvento(Evento nuevoEvento) {
        repo.guardar(nuevoEvento);
        mapaEventos.put(nuevoEvento.getId(), nuevoEvento);
    }

    /**
     * Buscar un evento por id
     * @param idABuscar
     * @return
     */
    public Evento buscarEventoPorId(String idABuscar) {
        return mapaEventos.get(idABuscar);
    }

    /**
     * Buscar un evento por precio mas alto
     * @return
     */
    public Evento buscarEventoMasCaro() {
        List<Evento> eventos = repo.listar();
        if (eventos.isEmpty()) return null;

        Evento masCaro = eventos.get(0);

        for (int i = 1; i < eventos.size(); i++) {
            if (eventos.get(i).getPrecio() > masCaro.getPrecio()) {
                masCaro = eventos.get(i);
            }
        }
        return masCaro;
    }

    /**
     * Mostrar catalogo
     */
    public void mostrarTodoElCatalogo() {
        mapaEventos.values().forEach(Evento::mostrarInformacion);
    }

    /**
     * Eliminar eventos pasados
     */
    public void eliminarEventosPasados() {
        Iterator<Evento> iterador = repo.listar().iterator();
        while (iterador.hasNext()) {
            Evento e = iterador.next();
            if (e.getFecha().isBefore(LocalDate.now())) {
                mapaEventos.remove(e.getId());
                System.out.println("Evento caducado eliminado: "+ e.getNombre());
                iterador.remove();
            }
        }
    }
    /**
     * Contar eventos gratuitos
     * @return
     */
    public long contarEventosGratuitos() {
        return mapaEventos.values().stream()
                .filter(e -> e.getPrecio() == 0)
                .count();
    }

    /**
     * Contar eventos por aforo
     * @param aforoMinimo
     * @return
     */
    public long contarEventosPorAforo(int aforoMinimo) {
        return mapaEventos.values().stream()
                .filter(e -> e.getRecinto().getAforoMaximo() >= aforoMinimo)
                .count();
    }

    /**
     * Cierre de eventos
     * @param sc
     */
    public void procesarCierreEventos(Scanner sc) {
        for (Evento e : mapaEventos.values()) {
            if (e.getEstado() == EstadoEvento.ACTIVO) {
                System.out.println("Cerrando: " + e.getNombre());

                if (e instanceof Partido p) {
                    System.out.print("Introduce resultado (ej. 2-1): ");
                    p.setResultadoMarcador(sc.nextLine());
                } else if (e instanceof Concierto c) {
                    System.out.print("Introduce lista de canciones: ");
                }
                e.finalizarEvento();
            }
        }
    }

    /**
     * Lista todos los eventos guardado en la Lista
     * @return
     */
    public List<Evento> listarTodosLosEventos(){
        return repo.listar();
    }

    /**
     * Genera informe financiero
     */
    public void generarInformeFinanciero() {
        Collection<Evento> eventos = mapaEventos.values();
        for (Evento e : mapaEventos.values()) {
            System.out.println("ID: " + e.getId());
            System.out.println("Evento: " + e.getNombre());
            System.out.printf(" - Coste Operativo: %.2f€%n", e.calcularCosteOperativo());
            System.out.printf(" - Precio Sugerido: %.2f€%n", e.calcularPrecioVentaRecomendado());
            System.out.println("-----------------------------------");
        }

    }

    public void importarEventosDesdeCSV(String rutaArchivo){
        File archivo = new File(rutaArchivo);
        if (archivo.exists()){
            try {
                BufferedReader lector = new BufferedReader(new FileReader(archivo));
                String linea;
                lector.readLine();
                while ((linea = lector.readLine()) != null){
                    System.out.println(linea);
                    String[] datos = linea.split(";");
                    String fechaStr;
                    String precio;
                    String aforo;
                    LocalDate fecha = null;
                    int aforoStr;
                    double precioStr;

                    try{
                        aforo = datos[3];
                        aforoStr = Integer.parseInt(aforo);
                    } catch (Exception e){
                        System.out.print("Error en el aforo: formato inválido" + e.getMessage());
                        LogUtil.registrar(ErrorNivel.ERROR,"ERROR: Fallo al importar linea del CSV: " + e.getMessage());
                        aforoStr = 0;
                    }

                    try {
                        precio = datos[4];
                        precioStr = Double.parseDouble(precio);
                    } catch (Exception e) {
                        System.out.print("Error en el precio: formato inválido" + e.getMessage());
                        LogUtil.registrar(ErrorNivel.ERROR,"ERROR: Fallo al importar linea del CSV: " + e.getMessage());
                        precioStr = 0;
                    }

                    try {
                        fechaStr = datos[2];
                        fecha = LocalDate.parse(fechaStr);
                    } catch (Exception e) {
                        System.out.print("Error en la fecha: formato inválido" + e.getMessage());
                        LogUtil.registrar(ErrorNivel.ERROR, "ERROR: Fallo al importar linea del CSV: " + e.getMessage());
                        fechaStr = null;
                    }

                    Evento concierto = new Concierto(datos[0], fecha, new Recinto(datos[0], datos[1], aforoStr), precioStr, null, null, 10, null);
                    this.repo.listar().add(concierto);
                    System.out.println("Importado " + datos[0]);
                    LogUtil.registrar(ErrorNivel.INFO,"Importado : " + datos[0]);
                }
            } catch (IOException e){
                System.err.println("No se ha podido leer el archivo " + e.getMessage());
            }
        }
    }
}