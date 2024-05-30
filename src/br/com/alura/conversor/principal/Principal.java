package br.com.alura.conversor.principal;

import br.com.alura.conversor.auxiliares.Auxiliar;
import br.com.alura.conversor.auxiliares.LogAuxiliar;
import br.com.alura.conversor.exceptions.OpcaoInvalidaException;
import br.com.alura.conversor.modelos.Taxa;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int opcao = 0;
        double valor = 0;
        double conversao = 0;

        Conversor conversor = new Conversor();

        while (opcao != 7) {
            System.out.println("*****************************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]\n");
            System.out.println("1) Real brasileiro =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Real brasileiro");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Real brasileiro =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Real brasileiro");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("*****************************************************");

            opcao = leitura.nextInt();
            if(opcao == 7) {
                break;
            }

            try {
                String[] codigos = Auxiliar.getCodigos(opcao);
                String codigoBase = codigos[0];
                String codigoDestino = codigos[1];

                System.out.println("Digite o valor que deseja converter: ");
                valor = leitura.nextDouble();

                conversao = conversor.calcularConversao(codigoBase, codigoDestino, valor);

                LogAuxiliar.addLog(codigoBase, codigoDestino, valor, conversao);

                System.out.format("\u001B[34mValor %.4f [%s] corresponde ao valor final de =>>>> %.4f [%s]\u001B[0m\n", valor, codigoBase, conversao, codigoDestino);
            } catch (OpcaoInvalidaException exception) {
                System.out.println("\u001B[31m" + exception.getMessage() + "\u001B[0m");
            } catch (RuntimeException exception) {
                System.out.println("\u001B[31mHouve um erro não identificado, entre em contato com o administrador.\u001B[0m");
                System.out.println(exception.getMessage());
            }
        }

        System.out.println("\u001B[32mO Conversor de Moeda finalizou corretamente.\u001B[0m");
    }
}
