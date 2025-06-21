import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {
    private static final Random random = new Random();

    public static void main(String[] args) {//inicia el main
        //creo un objeto
        MovilidadApp app = new MovilidadApp();
        CompletableFuture<Void> future = app.procesamientoViaje();
        //hace que el hilo espere
        future.join();
    }//termina el main

    //inicia calcularRuta
    //completablefuture indica que es asincrono y que regresa un valor string y que este metodo se llama calcularruta
    CompletableFuture<String> calcularRuta(){
        //suplyasyn es lo que se usa para indicar que es la primera parte de la cadena y que regresara un valor
        return CompletableFuture.supplyAsync(()->{
            //intentara hacer esto
            try{
                //indica que creamos un atributo llamado delay que tiene valor 2000 mas un numero random entre el 1000
                int delay = 2000 +random.nextInt(1000);
                //aqui ponemos que se va a dormir el tiempo que el atributo de arriba diga
                TimeUnit.MILLISECONDS.sleep(delay);
                return "Centro -> Este";
            }
            //pero si sale mal se hara esto
            catch(InterruptedException e){
                throw new RuntimeException("Error en cálculo de ruta", e);
            }
        });
    }//termina calcularRuta

    //calcular la tarifa de manera asincrona
    CompletableFuture<Double> estimarTarifa(){
        return CompletableFuture.supplyAsync(()->{
            //intentara hacer esto
            try{
                int delay = 1000 +random.nextInt(1000);
                TimeUnit.MILLISECONDS.sleep(delay);
                return 75.50;
            }
            //pero si falla, hara esto
            catch(InterruptedException e){
                throw new RuntimeException("Error en cálculo de tarifa", e);
            }
        });
    }//termina calcularTarifa

    //metodo para combinar ambas
    public CompletableFuture<Void> procesamientoViaje(){
        //crear objetos
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        System.out.println("Iniciando simulación de viaje...\n");
        System.out.println("💰 Estimando tarifa...");
        CompletableFuture<Void> resultado =
        rutaFuture.thenCombine(tarifaFuture,(ruta,tarifa)->
                "Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa)
                .exceptionally(ex -> {
                    // Manejo de errores
                    System.err.println("⚠️ Error en el proceso: " + ex.getMessage());
                    return "No se pudo completar la solicitud";
                })
                .thenAccept(System.out::println);  // Mostrar resultado final
        return resultado;
    }

}//estas es la llave de movilidadapp