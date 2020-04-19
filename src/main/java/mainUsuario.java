import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class mainUsuario {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Joao", 200);
        Usuario u2 = new Usuario("Pedro", 340);
        Usuario u3 = new Usuario("Roberto", 410);

        List<Usuario> usuarios = Arrays.asList(u1, u2, u3);

        for(Usuario u : usuarios) {
            System.out.println("Nome usuario: "+u.getNome());
        }

        Consumer mostradorDeUsuario = new Mostrador();
        usuarios.forEach(mostradorDeUsuario);

        Consumer mostradorDePontos = new MostradorPontos();
        usuarios.forEach(mostradorDePontos);

        //Implementa um consumer por de baixo dos panos..
        usuarios.forEach(d -> System.out.println("Nome: "+d.getNome()));


    }
}
