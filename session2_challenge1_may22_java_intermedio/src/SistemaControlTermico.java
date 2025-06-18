import java.util.concurrent.Callable;
public class SistemaControlTermico implements Callable<String> {
    //sobreescribir el metodo de callable
    @Override
    public String call(){
        return "temperatura estable (22°C)";
    }
}