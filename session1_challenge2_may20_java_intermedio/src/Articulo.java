public class Articulo extends MaterialCurso{
    protected int palabras;

    //constructor
    public Articulo(String titulo,String autor, int palabras){
        super(autor,titulo);
        this.palabras=palabras;
    }

    //sobrescribir el metodo
    @Override
    public void mostrarDetalle(){
        System.out.println(titulo + "- Autor: " + autor + " numero de palabras: " + palabras);
    }
}
