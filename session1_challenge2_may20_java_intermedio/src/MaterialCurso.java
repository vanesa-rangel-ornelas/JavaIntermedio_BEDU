public abstract class MaterialCurso {
    //atributos
    protected String titulo;
    protected String autor;

    //constructor
    public MaterialCurso(String titulo,String autor){
        this.titulo= titulo;
        this.autor=autor;
    }

    //necesita un metodo abstracto por lo menos
    public abstract void mostrarDetalle();
}
