import java.util.concurrent.Callable;
public class SistemaComunicaciones implements Callable<String> {
    @Override
    public String call(){
        return "enlace con estación terrestre establecido.";
    }
}