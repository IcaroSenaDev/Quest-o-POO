package questao2;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Digite o número de produtos: ");
        int n = Integer.parseInt(sc.nextLine());

        Produto[] produtos = new Produto[n];

        for (int i = 0; i < n; i++) {
            System.out.println(
                "\nDados do produto #" + (i + 1) + ":"
            );

            System.out.print(
                "Comum, usado ou importado (c/u/i)? "
            );
            char tipo = sc.nextLine()
                          .trim()
                          .toLowerCase()
                          .charAt(0);

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Preço: ");
            double preco = Double.parseDouble(
                sc.nextLine().trim().replace(",", ".")
            );

            if (tipo == 'i') {
                System.out.print("Taxa alfandegária: ");
                double taxa = Double.parseDouble(
                    sc.nextLine().trim().replace(",", ".")
                );

                produtos[i] =
                    new ProdutoImportado(nome, preco, taxa);

            } else if (tipo == 'u') {
                System.out.print(
                    "Data de fabricação (DD/MM/AAAA): "
                );

                LocalDate data = LocalDate.parse(
                    sc.nextLine().trim(),
                    formato
                );

                produtos[i] =
                    new ProdutoUsado(nome, preco, data);

            } else if (tipo == 'c') {
                produtos[i] = new Produto(nome, preco);

            } else {
                System.out.println(
                    "Tipo inválido. Digite c, u ou i."
                );
                i--;
            }
        }

        System.out.println("\nETIQUETAS DE PREÇO:");

        for (Produto produto : produtos) {
            System.out.println(produto.etiqueta());
        }

        sc.close();
    }
}
