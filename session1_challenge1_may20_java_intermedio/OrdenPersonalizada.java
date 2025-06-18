public class OrdenPersonalizada extends OrdenProduccion {
    //atributos personalizados
    private String cliente;

    //metodos
    //el constructor que extendera los atributos de ordenproduccion y agragara cliente
    public OrdenPersonalizada(String coding,int cantidad,String cliente){
        super (coding, cantidad);
        this.cliente=cliente;
    }

    //sobreescribire el metodo
    @Override
    public void mostrarResumen(){
        System.out.println("\nOrden personalizada: \nCodigo: " + coding + "\ncantidad: " + cantidad +"\ncliente: " + cliente);
    }

}
