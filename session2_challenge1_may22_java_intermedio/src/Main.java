import java.util.concurrent.*;

public class Main{
    public static void main(String[]args) {
        //creo un objeto en donde determino cuantas "pelotas tengo"
        ExecutorService executor = Executors.newFixedThreadPool(4);

        //pongamosle un tiempo limite para que termine
        try{
            Future<String> comunicaciones = executor.submit(new SistemaComunicaciones());
            Future<String> termico = executor.submit(new SistemaControlTermico());
            Future<String> navegacion = executor.submit(new SistemaNavegacion());
            Future<String> soporte = executor.submit(new SistemaSoporteVital());

            // Obtener los resultados e imprimirlos
            System.out.println(comunicaciones.get());
            System.out.println(termico.get());
            System.out.println(navegacion.get());
            System.out.println(soporte.get());

            executor.awaitTermination(2, TimeUnit.SECONDS);
        }
        catch(InterruptedException ex){
            System.out.println("tiempo acabado");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        //para que deje de mandar hilos
        executor.shutdown();
    }
}