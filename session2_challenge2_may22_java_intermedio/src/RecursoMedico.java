import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico{
    //atributo
    private final String nombre;
    private final ReentrantLock lock=new ReentrantLock();;

    //constructor
    public RecursoMedico(String nombre){
        this.nombre=nombre;
    }
    //metodo
    public void usar(String profesional){
        //bloquea el acceso al bloque
        lock.lock();
        //empieza el bloque
        try{
            System.out.println(profesional + " ha ingresado a " + nombre);
            Thread.sleep(3000);  // Simula tiempo de uso del recurso
            System.out.println(profesional + " ha salido de " + nombre);
        }
        //que hacer en caso de que falle
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        //sin importar si se ejecuta normalmente o si se se ejecuta la excepcion finally siempre se ejecuta
        finally{
            //abre el candado, libera el recurso
            lock.unlock();
        }
    }
}