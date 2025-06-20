import java.util.List;
import java.util.Optional;

public class Main{
    public static void main(String []args){
        //debo crear una lista para poder aplicar la programacion funcional
        List<Pedido> pedidos = List.of(
                new Pedido("vanesa","domicilio","4423297719"),
                new Pedido("jesus","en sucursal",null),
                new Pedido("yan","domicilio","4425761245")
        );

        List<String> mensajes = pedidos.stream()
                //filtrar si la entrega es a domicilio
                .filter(p -> p.getTipo_entrega().equalsIgnoreCase("domicilio"))
                //obtener el numero de telefono
                .map(Pedido::getTelefono)
                //si el telefono esta presente, sino se eliminan los pedidos sin numero
                .filter(Optional::isPresent)
                //obtiene el numero de telefono
                .map(Optional::get)
                //mensaje impreso
                .map(tel -> "📞 Confirmación enviada al número: " + tel)
                //junta los mensajes en una lista
                .toList();

        //muesta los mensajes
        System.out.println("Confirmaciones de pedidos a domicilio:");
        //por cada linea se imprime
        mensajes.forEach(System.out::println);
    }
}