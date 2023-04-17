import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//classe main

public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException {
     
        //leitura dos arquivos
        Data data = new Data();
        data.read("test.txt"); //le arquivos
        List<Monkey> monkeys = new ArrayList<>();

        
        //importar lista
        monkeys = data.getMonkeys();

        //inicia o jogo
        for (int i = 0; i < data.getRounds(); i++) {
            for (Monkey m : monkeys) {
                int evenMonkey = m.getEvenMonkey();
                int oddMonkey = m.getOddMonkey();
                m.sendCoconuts(monkeys.get(evenMonkey), monkeys.get(oddMonkey));
            }
        }        
        
        Monkey winner = monkeys.get(0);

        for (Monkey m : monkeys) {
            if(m.quantCoconut()>winner.quantCoconut())  winner=m;
        }

        System.out.println();
        System.out.printf("O macaquinho vencedor foi o: %d com %d cocos.",  winner.getId(), winner.quantCoconut());

    }
}
