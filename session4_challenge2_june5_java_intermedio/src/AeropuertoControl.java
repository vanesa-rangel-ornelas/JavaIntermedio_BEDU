import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl{
    private Random random = new Random();

    public static void main (String[]args){
        //creo un objeto
        AeropuertoControl aeropuerto = new AeropuertoControl();
        //mensaje del sistema independiente
        System.out.println("verificando las condiciones para aterrizaje...\n");

        //inicio la verificacion de cada uno de los parametros y obtengo si son true or false
        CompletableFuture<Boolean> pista = aeropuerto.verificarPista()
                .exceptionally(ex->{
                    System.out.println("error en la verificaion de pista "+ ex.getMessage());
                    return false;
                        });
        //aqui el completablefuture indica que de manera asincrona yo voy a llevar a cabo las siguientes acciones
        CompletableFuture<Boolean> clima = aeropuerto.verificarClima()
                //pero si una excepcion pasa se hara lo siguiente
                .exceptionally(ex->{
                    System.out.println("error en la verificacion del clima "+ ex.getMessage());
                    return false;
                        });
        //de manera asincrona, me regresaras un valor booleano no primitivo que llamare trafico,ese valor lo obtendras de que a mi objeto aeropuerto, que cree en la linea 10, le apliques la funcion verificarTraficoAereo
        CompletableFuture<Boolean> trafico = aeropuerto.verificarTraficoAereo()
                //pero si pasara una excepcion llamada ex, entonces ejecutaria ese print y regesaria falso
                .exceptionally(ex-> {
                    System.out.println("error en la verificacion del trafico aereo "+ ex.getMessage());
                    return false;
                });
        CompletableFuture<Boolean> tierra = aeropuerto.verificarPersonalTierra()
                .exceptionally(ex->{
                    System.out.println("error en la verificacion del personal en tierra "+ ex.getMessage());
                    return false;
                        });
        //termino con la obtencion del true or false de cada parametro

        //ahora necesito comprimirlas en una con un metodo asincrono que no me regrese nada
        //sera igual al metodo asincrono que se le aplica allOf, que espera que todos los metodos dentro, se terminen
        CompletableFuture<Void> todasVerificaciones = CompletableFuture.allOf(pista,clima,trafico,tierra);

        //al objeto todasVerificaciones, se ejecutara algo que no devuelve nada ni depende del valor anterior
        todasVerificaciones.thenRun(()->{
            //intentara ejecutar esto
            try{
                //hare un atributo con valor de cada uno de los parametros
                boolean resultado_pista = pista.get();
                boolean resultado_trafico = trafico.get();
                boolean resultado_clima = clima.get();
                boolean resultado_tierra = tierra.get();

                System.out.println("\nPista disponible: " + resultado_pista);
                System.out.println("Clima favorable: " + resultado_clima);
                System.out.println("Tráfico aéreo despejado: " + resultado_trafico);
                System.out.println("Personal disponible: " + resultado_tierra);

                if(resultado_clima && resultado_trafico && resultado_pista && resultado_tierra)
                    System.out.println("aterrizaje autorizado ");
                else
                    System.out.println("aterrizaje denegado ");
            }
            //pero si falla
            catch(InterruptedException | ExecutionException ex){
                System.err.println("Error crítico en procesamiento: " + ex.getMessage());
            }
                }).join();
    }

    CompletableFuture<Boolean> verificarPista(){
        return CompletableFuture.supplyAsync(()->{
            //procedimiento para simular latencia (tiempo que tarda)
            simularLatencia();
            //procedimiento para variar la probabilidad
            return probabilidad(80);
                });
    }

    CompletableFuture<Boolean> verificarClima(){
        return CompletableFuture.supplyAsync(()->{
            //tambien se simula su latencia
            simularLatencia();
            //se varia la probabilidad
            return probabilidad(85);
                });
    }

    CompletableFuture<Boolean> verificarTraficoAereo(){
        return CompletableFuture.supplyAsync(()->{
            simularLatencia();
            return probabilidad(90);
                });
    }

    CompletableFuture<Boolean> verificarPersonalTierra(){
        return CompletableFuture.supplyAsync(()->{
            simularLatencia();
            return probabilidad(95);
                });
    }

    //descripciones
    private void simularLatencia(){
        //va a intentar hacer esto
        try{
            //el valor de delay estara entre 2000 y 3000
            int delay = 2000 + random.nextInt(1000);
            TimeUnit.MILLISECONDS.sleep(delay);
        }
        //pero si falla hara esto
        catch(InterruptedException e){
            //avisa a los demas hilos que ha sido interrumpido para que ya no lo esperen
            Thread.currentThread().interrupt();
            //throw lanza una excepcion y new runtimeexception crea una una excepcion
            throw new RuntimeException("error en latencia",e);
        }
    }

    private boolean probabilidad(int nprobabilidad){
        //random genera un numero aleatorio entre 0 y 99
        //si el numero aleatorio es mayor a la probabilidad, retorna false
        return random.nextInt(100)< nprobabilidad;
    }
}