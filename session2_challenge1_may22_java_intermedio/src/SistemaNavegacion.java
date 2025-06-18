import java.util.concurrent.Callable;
public class SistemaNavegacion implements Callable<String> {
    //como implements es una plantilla sin codigo, debo suministrarselo yo, es decir sobreescribirlo
    @Override
    //que sobreescribo, pues el metodo que Callable tiene, que es call
    public String call(){
        //debe regresar algo a fuerzas
        return "Navegación: trayectoria corregida con éxito.";
    }
}