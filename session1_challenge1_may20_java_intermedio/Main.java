import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[]args){
        //ArrayList() es una lista vacia de OrdenMasa
        //.add(new OrdenMasa(...)): Añade nuevas órdenes a la lista
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));

        List<OrdenPersonalizada> ordenesPersonalizada = new ArrayList<>();
        ordenesPersonalizada.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizada.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));

        // Mostrar todas las órdenes
        GestorOrdenes.mostrarOrdenes(ordenesMasa);
        GestorOrdenes.mostrarOrdenes(ordenesPersonalizada);
        GestorOrdenes.mostrarOrdenes(ordenesPrototipo);

        // Procesar órdenes personalizadas
        List<OrdenProduccion> listaProcesamiento = new ArrayList<>(ordenesPersonalizada);
        GestorOrdenes.procesarPersonalizadas(listaProcesamiento, 200);
    }

}
