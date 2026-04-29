import java.util.Scanner;

public class AppSimulacao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        DoubleLinkedListOfInteger estacoesMetro = new DoubleLinkedListOfInteger();

        //inicializa com 5 estacoes de metro
        for(int i=1; i<=5; i+=2){ //i + 2 pq a primeira vai ser 1 e a segundo vai ser a três
            estacoesMetro.add(i);
        } 

        //estacao atual(comeca na primeira)
        int currentIndex = 0;

        int opcao;
        do{
           System.out.println("-----Sistema de Metro-----");
           System.out.println("Estaçãoa atual" +estacoesMetro.get(currentIndex));
           System.out.println("1 - Avança uma estação");
           System.out.println("2 - Volta uma estação");
           System.out.println("3 - Insere nova estação depois da atual ");
           System.out.println("4 - Remova a estação atual");
           System.out.println("5 - Exibir todas as estações");
           System.out.println("Digite aqui uma das opções");
           opcao = sc.nextInt();
           switch (opcao) {
            case 1: 
                 if (currentIndex < estacoesMetro.size()-1){
                      currentIndex++;
                 }else{
                    System.out.print("Não é possivel, pois esta na ultima");
                 }
                break;
            case 2:
                if (currentIndex > 0){
                    currentIndex--;

                }else{
                    System.out.print("Não é possivel, pois está na primeira");

                }
                break;
           case 3:
                System.out.print("Digite o numero da estação");
                int novaEstacao = sc.nextInt();
                estacoesMetro.add(currentIndex+1, novaEstacao);
                    currentIndex++; //avaça para nova estação
                break;
            case 4: 
                if(estacoesMetro.size() > 1 ){
                    System.out.print("Removendo a estação" +estacoesMetro.remove(currentIndex));
                    if(currentIndex >= estacoesMetro.size()){
                        currentIndex--;
                    }

                }else{
                    System.out.print("Não é possivel, pois só existe uma estação");
                }
                break;
            case 5:
                System.out.print(estacoesMetro.toString()); 
                break;
            default:
                break;
           }

        }while(opcao != 0);
    }
}
