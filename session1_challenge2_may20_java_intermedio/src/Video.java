public class Video extends MaterialCurso{
    //atributos personalizados
    protected int duracion;

    //constructor
    public Video(int duracion,String titulo,String autor){
        super(titulo,autor);
        this.duracion=duracion;
    }

    //saco su get
    public int getDuracion(){
        return duracion;
    }

    //sobrescribir el metodo
    @Override
    public void mostrarDetalle(){
        System.out.println(titulo + "- Autor: " + autor + " duracion: " + duracion);
    }
}