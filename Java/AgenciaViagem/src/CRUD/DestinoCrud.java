package CRUD;

import java.util.Scanner;

import DAO.CompanhiasDAO;
import DAO.DestinoDAO;
import modelo.Companhias;
import modelo.Destino;

public class DestinoCrud {

	public static void main(String[] args) {
		
		DestinoDAO destinoDAO = new DestinoDAO();
		CompanhiasDAO companhiaDAO = new CompanhiasDAO();
	
		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";
		String origem = "";
		String tipoDestino = "";
		double precoDestino = 0;
		int id_companhia = 0;

		do {
			
			System.out.println("--------------------------------");
			System.out.println("========== CRUD DESTINO =========");
			System.out.println("---------------------------------");
			System.out.println("-- 1 ---- Cadastrar Destino -----");
			System.out.println("-- 2 ---- Consultar Destino -----");
			System.out.println("-- 3 ---- Atualizar Destino -----");
			System.out.println("-- 4 ---- Excluir  --------------");
			System.out.println("-- 5 ---- sair  ---------------\n");
			System.out.println("Selecione uma opção");
			System.out.println("-------------------------------\n");
			opcao = s.nextInt();
			s.nextLine();		
					
			
			switch (opcao) {
			
			case 1:
				// CREATE
				System.out.println("Digite o nome do Destino: ");
				nome = s.nextLine();
				
				System.out.println("Digite a origem do Destino: ");
				origem = s.nextLine();			
				
				System.out.println("Digite o tipo de Destino: ");
				tipoDestino = s.nextLine();
				
				System.out.println("Digite o valor da passagem para o destino: ");
				precoDestino = s.nextDouble();
				
				System.out.println("Digite o id da Companhia Aérea: ");
				id_companhia = s.nextInt();
				s.nextLine();					
			
				Companhias comp = new Companhias();			

				Destino d1 = new Destino(id, nome, origem,tipoDestino, precoDestino, comp);					
				
				destinoDAO.save(d1);

				System.out.println("\n***  Cadastrou  ***\n");

				break;
			case 2:
			
				// READ
				for (Destino dest : destinoDAO.getDestino()) {
					System.out.println("Id: " + dest.getId() + " Nome: " + dest.getNome() + " Companhia Aérea: "
							+ dest.getCompanhias().getNome());
					
					System.out.println("----------------------------------- ");
				}
								
				System.out.println("\n**** Consultou **** \n");
				
				break;
				
			case 3:
				// UPDATE
				
				System.out.println("Digite o id do Destino: ");
				posicao = s.nextInt();
				s.nextLine();	
				
				System.out.println("Digite o nome do Destino: ");
				nome = s.nextLine();
				
				System.out.println("Digite a origem do Destino: ");
				origem = s.nextLine();		
				
				System.out.println("Digite o tipo de Destino: ");
				tipoDestino = s.nextLine();
				s.nextLine();
				
				System.out.println("Digite o valor da passagem para o destino: ");
				precoDestino = s.nextDouble();
				
				System.out.println("Digite o id da Companhia Aérea: ");
				id_companhia = s.nextInt();
				s.nextLine();
												
				Companhias cea1 = companhiaDAO.getCopmpanhiasById(id_companhia);

				Destino d2 = new Destino(posicao, nome, origem, tipoDestino, precoDestino, cea1);
				
				destinoDAO.update(d2);

				System.out.println("\n**** Atualizou **** \n");
				
				break;
						
				
			case 4:
				// DELETE
				
				System.out.println("Digite o id do destino para exclusao: ");

				try {
					posicao = s.nextInt();

					destinoDAO.removeById(posicao);

				} catch (Exception e) {
					
					System.out.println(" Nenhum contato para excluir ");
				}

				break;		
									
				case 5:
					// Sair
				System.out.println(" === Obrigado por usar nossa Agencia de Viagem=== ");

				break;

			default:

				System.out.println("opção invalida, digite novamente.");
				break;
			}
			
		} while (opcao != 5);

		s.close();

	}
}
