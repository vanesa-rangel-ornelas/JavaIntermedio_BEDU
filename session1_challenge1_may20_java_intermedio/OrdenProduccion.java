public abstract class OrdenProduccion{

    //attributes
    protected String coding;
    protected int cantidad;

    //methods
    //constructor
    public OrdenProduccion(String coding, int cantidad ){
        this.coding = coding;
        this.cantidad = cantidad;
    }

    //necesita por lo menos un metodo abstracto
    public abstract void mostrarResumen();//como es abstracto no lleva llaves
       //como es abstracto puedo decirle que lo que haga me vale vrg asi que no tiene nada
}
