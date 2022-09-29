package CRUD;

import java.util.Scanner;

import DAO.CompanhiasDAO;
import modelo.Companhias;

public class CompanhiasCrud {

	public static void main(String[] args) {

		CompanhiasDAO companhiaDAO = new CompanhiasDAO();

		Scanner cea = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";

		do {
			
			System.out.println("---------------------------------------");
			System.out.println("============ CRUD COMPANHIAS ==========");
			System.out.println("---------------------------------------");
			System.out.println("-- 1 -- Cadastrar Companhias Aéreas ---");
			System.out.println("-- 2 -- Consultar Campanhias Aéreas ---");
			System.out.println("-- 3 -- Atualizar Campanhia Aérea------");
			System.out.println("-- 4 -- Excluir  ----------------------");
			System.out.println("-- 5 -- sair  -----------------------\n");
			System.out.println("Selecione uma opção");
			System.out.println("-------------------------------------\n");
			opcao = cea.nextInt();
			cea.nextLine();
			
			
			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o nome da Companhia Aérea:");
				nome = cea.nextLine();

				Companhias c1 = new Companhias(id, nome);

				companhiaDAO.save(c1);

				System.out.println("\n**** Cadastrou **** \n ");
				
				break;

			case 2:
				// READ
				for (Companhias a : companhiaDAO.getCompanhias()) {
					System.out.println("Id: " + a.getId() + "Nome: " + a.getNome());

				}
				
				System.out.println("\n**** Consultou **** \n");
				break;

			case 3:
				// UPDATE
				System.out.println("Digite o id da Companhia Aérea");
				posicao = cea.nextInt();
				
				System.out.println("Digite o novo nome da Companhia Aèrea");
				nome = cea.nextLine();
				cea.nextLine();
				
				Companhias cea2 = new Companhias(posicao, nome);

				companhiaDAO.update(cea2);

				System.out.println("\n**** Atualizou **** \n");
				break;

			case 4:
				// DELETE
				System.out.println("Digite o id da Companhia Aéria: ");
				posicao = cea.nextInt();
				
				companhiaDAO.deleteById(posicao);

				break;
								
			case 5:

				System.out.println(" === Obrigado por usar nossa Agencia de Viagem === ");

				break;

			default:

				System.out.println("opção invalida, digite novamente.");
				break;
			}
			
		} while (opcao != 5);

		cea.close();

	}
}
				
			