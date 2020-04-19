import java.util.function.Consumer;

public class MostradorPontos implements Consumer<Usuario> {
    @Override
    public void accept(Usuario u) {
        System.out.println("Pontos : "+u.getPontos());
    }
}
