package interfaces.funcionais;

import interfaces.funcionais.entidade.Livros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class mainInterfacesFuncionais {
    public static void main(String[] args) {
        //Interfaces funcionais possuem apenas um método abstrato. Sempre poderá ser
        //instanciada através de um método lambda.

        //instanciando uma Thread e um Runnable que conta até 1000.
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <= 1000 ; i++) {
//                    System.out.println(i);
//                }
//            }
//        };
//        new Thread(r).start();
//
//        //mesma instancia, reduzindo.
//        Runnable r2 = () -> {
//            for (int i = 0; i <= 1000; i++) {
//                System.out.println(i);
//            }
//        };
//        new Thread(r2).start();
//
//        //mesma instancia, em um único statement
//        new Thread(() -> {
//            for (int i = 0; i <= 1000 ; i++) {
//                System.out.println(i);
//            }
//        }).start();

        //Usando Comparator para realizar uma ordenação
        List<Livros> livrosOrdenados = listaLivros().stream().sorted((l1, l2) -> l1.getNome().compareTo(l2.getNome()))
                .collect(Collectors.toList());
        livrosOrdenados.forEach(d -> System.out.println("LIVRO: "+d.getNome()+" - "+"VALOR:"+d.getValor()));
    }
    
    private static List<Livros> listaLivros (){
        List<Livros> livros = new ArrayList<>();
        
        Livros l1 = new Livros("Harry Potter - A pedra Filosofal", 40, "Novo");
        livros.add(l1);
        Livros l2 = new Livros("O Ultimo dos Moicanos",20,"Usado");
        livros.add(l2);
        Livros l3 = new Livros("Paulo e Estevão",70,"Semi-novo");
        livros.add(l3);
        Livros l4 = new Livros("Harry Potter - E o prizioneiro de Azkaban", 45, "Semi-novo");
        livros.add(l4);
        Livros l5 = new Livros("Harry Potter - A pedra Filosofal", 15, "Velho");
        livros.add(l5);
        Livros l6 = new Livros("As arvores", 55, "Novo");
        livros.add(l6);
        return livros;
    }
}
