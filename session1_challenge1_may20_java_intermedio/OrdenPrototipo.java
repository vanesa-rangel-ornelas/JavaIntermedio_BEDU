public class OrdenPrototipo extends OrdenProduccion{
    //atributo personalizado
    String fase_desarrollo ;

    //metodos
    //constructor
    public OrdenPrototipo(String coding,int cantidad,String fase_desarrollo){
        super(coding,cantidad);
        this.fase_desarrollo=fase_desarrollo;
    }

    //sobrescribir el metodo
    @Override
    public void mostrarResumen(){
        System.out.println("\nOrden prototipo: \nCodigo: " + coding + "\ncantidad: " + cantidad +"\nfase de desarrollo: " + fase_desarrollo);
    }
}
