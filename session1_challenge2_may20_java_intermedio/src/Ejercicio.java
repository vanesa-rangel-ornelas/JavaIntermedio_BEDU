public class Ejercicio extends MaterialCurso{
    private boolean revisado;

    //constructor
    public Ejercicio(String titulo,String autor){
        super(autor,titulo);
        this.revisado=false;
    }

    //su setter
    public void setRevisado(boolean revisado){
        this.revisado=revisado;
    }

    //sobrescribir el metodo
    @Override
    public void mostrarDetalle(){
        System.out.println(titulo + "- Autor: " + autor + " revisado: " + revisado);
    }
}
