public class Citas implements Runnable{
    //atributos
    private final String nombre;
    private final RecursoMedico recurso;

    //constructor de los atributos
    public Citas(String nombre,RecursoMedico recurso){
        this.nombre=nombre;
        this.recurso=recurso;
    }

    //sobreescribir su methodo
    @Override
    public void run(){
        recurso.usar(nombre);
    }
}