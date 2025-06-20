package loja.app;

import loja.model.*;
import loja.util.CalculadoraDescontos;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        int opcao;
        do {
            System.out.println("============");
            System.out.println("Menu da Loja do Érico !");
            System.out.println("(1) Cadastrar produto.");
            System.out.println("(2) Listar produtos cadastrados.");
            System.out.println("(3) Aplicar desconto a um produto em específico.");
            System.out.println("(4) Encontrar produto mais caro (sem desconto).");
            System.out.println("(5) Encontrar produto mais barato (com desconto).");
            System.out.println("(6 ou qualquer outra entrada) Encerrar programa.");
            System.out.println("============");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                
                case 1:
                    System.out.println("============");
                    System.out.println("Tipos de produtos disponíveis:\n(1) Alimento.\n(2) Eletrônico.\n(3) Roupa.");
                    System.out.print("\nEscolha um deles: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nCódigo: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nNome: ");
                    String nome = scanner.nextLine();
                    System.out.print("\nPreço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("\nQuantidade em estoque: ");
                    int estoque = scanner.nextInt();
                    scanner.nextLine();
                    Produto novoProduto = null;
                    
                    if (tipo == 1) {
                        System.out.print("\nData de validade do alimento (DD/MM/AAAA): ");
                        String validade = scanner.nextLine();
                        System.out.print("\nTipo do alimento (somente perecível ou não-perecível): ");
                        String tipoAli = scanner.nextLine();
                        novoProduto = new Alimento(codigo, nome, preco, estoque, validade, tipoAli);
                    } 
                    
                    else if (tipo == 2) {
                        System.out.print("\nMarca: ");
                        String marca = scanner.nextLine();
                        System.out.print("\nModelo: ");
                        String modelo = scanner.nextLine();
                        System.out.print("\nGarantia em meses: ");
                        int garantia = scanner.nextInt();
                        scanner.nextLine();
                        novoProduto = new Eletronico(codigo, nome, preco, estoque, marca, modelo, garantia);
                    } 
                    
                    else if (tipo == 3) {
                        System.out.print("\nTamanho: ");
                        String tamanho = scanner.nextLine();
                        System.out.print("\nCor: ");
                        String cor = scanner.nextLine();
                        System.out.print("\nMaterial: ");
                        String material = scanner.nextLine();
                        novoProduto = new Roupa(codigo, nome, preco, estoque, tamanho, cor, material);
                    } 
                    
                    else {
                        System.out.println("Erro: tipo de produto inválido.");
                        break;
                    }
                    produtos.add(novoProduto);
                    System.out.println("Produto cadastrado com sucesso!");
                    System.out.println("============");
                    break;
                
                case 2:
                    System.out.println("============");
                    System.out.println("Produtos Cadastrados:");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado...");
                    } 
                    else {
                        for (Produto p : produtos) {
                            System.out.println(p.toString());
                        }
                    }
                    System.out.println("============");
                    break;
                
                case 3:
                    System.out.println("============");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado para aplicar desconto...");
                    } 
                    else {
                        System.out.print("Digite o código do produto: ");
                        int codigoBusca = scanner.nextInt();
                        scanner.nextLine();
                        boolean encontrado = false;
                        for (Produto p : produtos) {
                            if (p.getCodigo() == codigoBusca) {
                                System.out.println("Preço original: " + p.getPreco());
                                double novoPreco = p.aplicarDesconto();
                                System.out.println("Novo preço com desconto: " + novoPreco);
                                encontrado = true;
                                break;
                            }
                        }
                        if (encontrado == false) {
                            System.out.println("Produto não encontrado...");
                        }
                    }
                    System.out.println("============");
                    break;

                case 4:
                    System.out.println("============");
                    Produto maisCaro = CalculadoraDescontos.encontrarProdutoMaisCaro(produtos);
                    if (maisCaro != null) {
                        System.out.println("Produto mais caro (sem desconto):\n" + maisCaro);
                    } 
                    else {
                        System.out.println("Nenhum produto cadastrado...");
                    }
                    System.out.println("============");
                    break;
                
                case 5:
                    System.out.println("============");
                    Produto maisBarato = CalculadoraDescontos.encontrarProdutoMaisBarato(produtos);
                    if (maisBarato != null) {
                        System.out.println("Produto mais barato (com desconto):\n" + maisBarato);
                    } 
                    else {
                        System.out.println("Nenhum produto cadastrado...");
                    }
                    System.out.println("============");
                    break;
                default:
                    System.out.println("Fim do programa.");
                    return;
            }
        }
        while (opcao >= 1 || opcao <= 6);
        scanner.close();
    }
}