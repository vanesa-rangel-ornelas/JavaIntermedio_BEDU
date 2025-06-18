import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{
    public static void main(String []args) {
        //crear el recurso medico a compartir
        RecursoMedico cirugia = new RecursoMedico("Sala de cirujias");

        //crear al executor y aplicarle que tiene 4 hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("Iniciando simulación de acceso al recurso...\n");

        //llamando a los hilos
        executor.submit(new Citas("Dra. Sánchez", cirugia));
        executor.submit(new Citas("Dr. Gómez", cirugia));
        executor.submit(new Citas("Enfermero López", cirugia));
        executor.submit(new Citas("Dra. Ruiz", cirugia));

        //se cierran las ordenes
        executor.shutdown();
    }
}