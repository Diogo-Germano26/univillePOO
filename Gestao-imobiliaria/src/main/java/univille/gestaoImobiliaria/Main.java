package univille.gestaoImobiliaria;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        int escolha;
        Scanner scanner = new Scanner(System.in);
        System.out.println("===========Imobiliaria DL==============");
        System.out.println();
        System.out.println("Bem vindo(a) ao sistema de gestão imobiliária da Imobiliaria DL !");
        System.out.println();
        do{
            System.out.println("=========== Selecione qual área deseja entrar ==============");
            System.out.println("1- Clientes");
            System.out.println("2- Imóveis");
            System.out.println("3- Contratos de Aluguéis");
            escolha= scanner.nextInt();

            switch (escolha){
                case 1:
                    int escolhaCliente;
                    do{
                        System.out.println("--------- Área do Cliente ==============");
                        System.out.println();
                        System.out.println("=========== Selecione o que deseja fazer ==============");
                        System.out.println("1- Cadastrar um cliente");
                        System.out.println("2- Visualizar clientes com mais contratos");
                        System.out.println("3- Visualizar todos os clientes");
                        escolhaCliente = scanner.nextInt();


                    } while (escolhaCliente!=0);

            }
        }while (escolha!=0);
    }
}
