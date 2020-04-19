package interfaces.funcionais;

public class mainInterfacesFuncionais {
    public static void main(String[] args) {
        //Interfaces funcionais possuem apenas um método abstrato. Sempre poderá ser
        //instanciada através de um método lambda.

        //instanciando uma Thread e um Runnable que conta até 1000.
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 1000 ; i++) {
                    System.out.println(i);
                }
            }
        };
        new Thread(r).start();

        //mesma instancia, reduzindo.
        Runnable r = () -> {
            for (int i = 0; i <= 1000; i++) {
                System.out.println(i);
            }
        };
        new Thread(r).start();

        //mesma instancia, em um único statement
        new Thread(() -> {
            for (int i = 0; i <= 1000 ; i++) {
                System.out.println(i);
            }
        }).start();
    }
}
