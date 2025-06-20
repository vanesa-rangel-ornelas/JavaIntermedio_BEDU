import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String []args){

        //creo las listas
        List<Sucursal> sucursales = Arrays.asList(
                new Sucursal("Centro",Arrays.asList(
                        new Encuesta ("vanesa rangel","mal trato del doctor",3),
                        new Encuesta ("jesus dias",null,5),
                        new Encuesta ("yanet","largo tiempo de espera",2)
                )
                ),new Sucursal ("este",Arrays.asList(
                        new Encuesta ("paula","no me gusta el color de la pintura",1),
                        new Encuesta ("kevin",null,4)
                ))
        );

        //proceso con stream
        //stream es para indicar que voy a usar programacion funcional
        sucursales.stream()
                //flatMap = map-> transforma cada elemento del stream en otro elemento,flatMap->transforma cada elemento del Stream y los aplana en un unico Stream continuo
                .flatMap(sucursal->sucursal.getEncuestas().stream()
                        //filter filtra solo los elementos con ciertas caracteristicas
                        //toma la encuesta, si la ecuesta en la obtencion de calificacion es menor o igual a 3
                        .filter(encuesta-> encuesta.getCalificacion()<=3)
                        //una vez que se filtraron las encuestas con 3 o menos, se aplanan en un nuevo stream
                        .flatMap(encuesta->
                                encuesta.getComentario()
                                        //map convierte los elementos en streams
                                        //creo un nuevo objeto
                                        .map(comentario->new AbstractMap.SimpleEntry<>(
                                                sucursal.getNombre(),comentario
                                        ))
                                        .stream()
                        )
                )
                .map(entry -> "Sucursal " + entry.getKey() +
                        ": Seguimiento a paciente con comentario: \"" +
                        entry.getValue() + "\"")
                .forEach(System.out::println);
    }
}