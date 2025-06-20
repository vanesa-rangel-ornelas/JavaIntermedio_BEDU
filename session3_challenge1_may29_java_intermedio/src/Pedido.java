import java.util.Optional;

public class Pedido {
    //atributos
    private final String cliente;
    private final String tipo_entrega;
    private final String telefono;

    //metodos
    //necesito el constructor
    public Pedido(String cliente,String tipo_entrega,String telefono){
        this.cliente=cliente;
        this.tipo_entrega=tipo_entrega;
        this.telefono=telefono;
    }

    //debo hacer los getters (para obtener la informacion)
    public String getCliente(){
        return cliente;
    }
    public String getTipo_entrega(){
        return tipo_entrega;
    }
    //hacer un metodo especifico para valores nulos
    public Optional<String> getTelefono(){
        return Optional.ofNullable(telefono);
    }
}
