import entidade.TelefoneETipo;
import entidade.filhosDaP;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class trabalhandoStream {

    public static void main(String[] args) {

        List<String> alunos = Arrays.asList("pedro","daniel","joao","pedro-2","daniel-2","rebeca-2");

        //utilizando stream().filter() para selecionar da lista, apenas registros que contem um
        //numero espeficio.
        List<String> alunosComNumero2 = alunos.stream()
                .filter( aluno -> aluno.contains("2")).collect(Collectors.toList());
        System.out.println("LISTA SÓ COM ALUNOS QUE CONTEM O NUMERO 2 :: " + Arrays.toString(alunosComNumero2.toArray()));


        //Criando uma nova lista de CPFs dos fdp, a partir de uma lista preexistente.
        List<String> listaCpfDosFdp = listaFilhosDaPuta()
                .stream()
                .map(filhosDaP::getCpf)
                .collect(Collectors.toList());
        System.out.println("LISTA SÓ COM OS CPF's dos FDP :: " + Arrays.toString(listaCpfDosFdp.toArray()));

        //Utilizando map para trazer apenas as idades que existem na lista do Objeto filhosDaP.
        //utilizando o Reduce para fazer a soma de todas as idades do atributo (int) "idade".
        System.out.println(listaFilhosDaPuta()
                .stream()
                .map(filhosDaP::getIdade)
                .reduce(0, (acumulador, next) -> acumulador + next));


        //utilizando o metodo tirarRepetidos
        List<TelefoneETipo> listaTelefonesPorTipo = listaTelefones()
                .stream().filter( tirarRepetidos( registro -> registro.getTipoTelefone() + registro.getNumeroTelefone()))
                .collect(Collectors.toList());          //registro se transforma em ex.: celular8888


        listaTelefonesPorTipo.forEach(dado -> System.out.println("TIPO:: "+dado.getTipoTelefone()+" TELEFONE:: "+dado.getNumeroTelefone()));

    }

    private static List<filhosDaP> listaFilhosDaPuta () {
        List<filhosDaP> l = new ArrayList<filhosDaP>();

        filhosDaP f = new filhosDaP();
        f.setNome("Lucas");
        f.setEstado("df");
        f.setCpf("6666");
        f.setIdade(27);
        f.setCor("branco");
        l.add(f);

        filhosDaP f2 = new filhosDaP();
        f2.setNome("messias");
        f2.setEstado("df");
        f2.setCpf("2222");
        f2.setIdade(31);
        f2.setCor("branco");
        l.add(f2);

        filhosDaP f3 = new filhosDaP();
        f3.setNome("marcelo");
        f3.setCpf("1111");
        f3.setEstado("mg");
        f3.setIdade(18);
        f3.setCor("amarelo");
        l.add(f3);

        filhosDaP f4 = new filhosDaP();
        f4.setNome("roberto");
        f4.setCpf("5555");
        f4.setEstado("rj");
        f4.setIdade(70);
        f4.setCor("roxo");
        l.add(f4);

        filhosDaP f5 = new filhosDaP();
        f5.setNome("Eita");
        f5.setCpf("8888");
        f5.setCor("roxo");
        f5.setEstado("df");
        f5.setIdade(65);

        return l;
    }

    private static List<TelefoneETipo> listaTelefones () {
        List<TelefoneETipo> l = new ArrayList<>();

        TelefoneETipo t1 = new TelefoneETipo();
        t1.setTipoTelefone("celular");
        t1.setNumeroTelefone("8888");
        l.add(t1);

        TelefoneETipo t2 = new TelefoneETipo();
        t2.setTipoTelefone("celular");
        t2.setNumeroTelefone("8888");
        l.add(t2);

        TelefoneETipo t3 = new TelefoneETipo();
        t3.setTipoTelefone("fixo");
        t3.setNumeroTelefone("8888");
        l.add(t3);

        TelefoneETipo t4 = new TelefoneETipo();
        t4.setTipoTelefone("fixo");
        t4.setNumeroTelefone("7777");
        l.add(t4);

        TelefoneETipo t5 = new TelefoneETipo();
        t5.setTipoTelefone("comercial");
        t5.setNumeroTelefone("6666");
        l.add(t5);

        TelefoneETipo t6 = new TelefoneETipo();
        t6.setTipoTelefone("comercial");
        t6.setNumeroTelefone("6666");
        l.add(t6);

        return l;
    }

    //Predicate é uma função que retorna um Booleano.
    //Esse método irá retornar se um determinado valor está repetido ou não dentro de uma lista
    private static <T> Predicate<T> tirarRepetidos(Function<? super T, ?> extrator){
        Map<Object, Boolean> map = new ConcurrentHashMap<>();

        return d -> map.putIfAbsent(extrator.apply(d), Boolean.TRUE) == null;
    }
}
