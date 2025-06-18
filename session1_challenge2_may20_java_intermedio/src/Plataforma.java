import java.util.List;
import java.util.ArrayList;
public class Plataforma{

    //implementar los metodos genericos para que el main los pueda llamar
    public static void mostrarMateriales(List<? extends MaterialCurso> lista){
        for(MaterialCurso material:lista)
            material.mostrarDetalle();
    }

    public static int contarDuracionVideos(List<? extends Video> lista){
        int total =0;
        for(Video video:lista)
            total+=video.getDuracion();
        return total;
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
        for(Object obj: lista){
            if(obj instanceof Ejercicio){
                Ejercicio ejercicio = (Ejercicio) obj;
                ejercicio.setRevisado(true);
                System.out.println("Ejercicio " + ejercicio.titulo + " marcado como revisado.");
            }
        }
    }
}
