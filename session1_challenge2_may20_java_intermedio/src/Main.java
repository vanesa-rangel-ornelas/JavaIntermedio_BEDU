import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String[]args){
        //crear los objetos
        Video video1 = new Video(55,"top 5 perros mas fachas","vanesa rangel");
        Video video2 = new Video(3,"clase completa de fundamentos del azucar","jesus dias");
        Articulo articulo1 = new Articulo("kevin palosanto","los peligros del uso de zapatos en un mundo tecnlogico",68327);
        Articulo articulo2 = new Articulo("catalina ornelas","yanera bandolera",198);
        Ejercicio ejercicio1 = new Ejercicio("julio marck","julio en agosto");
        Ejercicio ejercicio2 = new Ejercicio("jesus monrroy","atenciones humanas basicas en interacciones sociales");

        // Lista de todos los materiales
        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.add(video1);
        materiales.add(video2);
        materiales.add(articulo1);
        materiales.add(articulo2);
        materiales.add(ejercicio1);
        materiales.add(ejercicio2);

        // Lista de videos
        List<Video> videos = new ArrayList<>();
        videos.add(video1);
        videos.add(video2);

        System.out.println("Materiales del curso:");
        Plataforma.mostrarMateriales(materiales);

        System.out.println("\n🎥 Duración total de videos: " + Plataforma.contarDuracionVideos(videos) + " minutos");

        System.out.println();
        Plataforma.marcarEjerciciosRevisados(materiales);

    }
}