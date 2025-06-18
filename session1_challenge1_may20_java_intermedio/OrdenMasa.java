public class OrdenMasa extends OrdenProduccion{
    //no tiene atributos propios por lo que ire directo a los metodos

    //method
    //constructor pese que aunque puede llamar al de la madre me puede dar un error
    public OrdenMasa(String coding,int cantidad){
        //como esta heredando esto atributos solo debo poner super llamando a los atributos de ordenproduccion
        super(coding,cantidad);
    }

    //voy a sobreescribir el metodo abstracto
    @Override
    public void mostrarResumen(){
        System.out.println("\nOrden masa: \nCodigo: " + coding + "\ncantidad: " + cantidad );
    }
}