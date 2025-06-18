import java.util.List;

public class GestorOrdenes {
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista){
        System.out.println("ordenes registradas: ");
        for(OrdenProduccion orden:lista)
            orden.mostrarResumen();
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costo_adicional ){
        System.out.println("procesando ordenes personalizdas...");
        for(Object obj: lista){
            if(obj instanceof OrdenPersonalizada){
                OrdenPersonalizada orden = (OrdenPersonalizada) obj;
                System.out.println("Orden " + orden.coding + " ajustada con costo adicional de $" + costo_adicional);
            
            }
        }

    }
}
