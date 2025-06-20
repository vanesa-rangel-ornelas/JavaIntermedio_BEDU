import java.util.Optional;

public class Encuesta {
    //atributes
    private String paciente;
    private String comentario;
    private int calificacion;

    //crear un constructor
    public Encuesta(String paciente,String comentario, int calificacion){
        this.paciente=paciente;
        this.comentario=comentario;
        this.calificacion=calificacion;
    }
    //metodo
    public int getCalificacion(){
        return calificacion;
    }

    public Optional<String> getComentario(){
        return Optional.ofNullable(comentario);
    }
}
