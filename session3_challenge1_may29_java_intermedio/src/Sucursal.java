import java.util.List;

public class Sucursal {
    //atributos
    private String nombre;
    List<Encuesta> encuestas;

    //constructor
    public Sucursal(String nombre,List<Encuesta> encuestas){
        this.nombre=nombre;
        this.encuestas=encuestas;
    }
    //get
    public String getNombre(){
        return nombre;
    }
    public List<Encuesta> getEncuestas(){
        return encuestas;
    }

}
