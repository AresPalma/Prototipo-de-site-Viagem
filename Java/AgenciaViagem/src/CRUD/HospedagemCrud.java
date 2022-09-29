package CRUD;

import java.util.Scanner;

import DAO.HospedagemDAO;
import modelo.Hospedagem;

public class HospedagemCrud {

	public static void main(String[] args) {

		HospedagemDAO hospedagemDAO = new HospedagemDAO();
		Hospedagem hosped = new Hospedagem();

		Scanner h = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		
		String nome = "";
		String tel = "";
		String cidadeEstado = "";
		String logradouro = "";
		double valorHosped = 0;
		

		do {
			
			System.out.println("----------------------------------");
			System.out.println("======== CRUD HOSPEDAGEM =========");
			System.out.println("----------------------------------");
			System.out.println("-- 1 -- Cadastrar hospedagem -----");
			System.out.println("-- 2 -- Consultar hospedagem -----");
			System.out.println("-- 3 -- Atualizar hospedagem -----");
			System.out.println("-- 4 -- Excluir  -----------------");
			System.out.println("-- 5 -- sair  ------------------\n");
			System.out.println("Selecione uma opção");
			System.out.println("-------------------------------\n");
			opcao = h.nextInt();
			
			switch (opcao) {

			case 1:

				// CREATE
				System.out.println("Digite o nome da hospedagem: ");
				nome = h.next();
				hosped.setNome(nome);

				System.out.println("Digite o telefone da hospedagem: ");
				tel = h.next();
				hosped.setTel(tel);

				System.out.println("Digite a cidade/estado da hospedagem: ");
				cidadeEstado = h.next();
				hosped.setCidadeEstado(cidadeEstado);

				System.out.println("Digite logradouro da hospedagem: ");
				logradouro = h.next();
				hosped.setLogradouro(logradouro);

				System.out.println("Digite o valor da hospedagem/diaria: ");
				valorHosped = h.nextDouble();
				hosped.setPrecoHosped(valorHosped);

				hospedagemDAO.save(hosped);

				System.out.println("\n**** Cadastrou **** \n ");
				
				break;

			case 2:
				// READ
			
				for (Hospedagem hp : hospedagemDAO.getHospedagem()) {

					System.out.println("NOME: " + hp.getNome());
					System.out.println("TEL: " + hp.getTel());
					System.out.println("CIDADE/ESTADO: " + hp.getCidadeEstado());
					System.out.println("LOGRADOURO: " + hp.getLogradouro());
					System.out.println("VALOR DA DIARIA: " + hp.getPrecoHosped());

					System.out.println("----------------------------------- ");
				}
				System.out.println("\n**** Consultou **** \n");
				
				break;
			
			case 3:

				// UPDATE
				System.out.println("Digite o id da hospedagem: ");
				posicao = h.nextInt();
				
				System.out.println("Digite o nome da hospedagem: ");
				nome = h.next();
				hosped.setNome(nome);

				System.out.println("Digite o novo numero de telefone: ");
				tel = h.next();
				hosped.setTel(tel);

				System.out.println("Digite a nova cidade/estado da hospedagem: ");
				cidadeEstado = h.next();
				hosped.setCidadeEstado(cidadeEstado);

				System.out.println("Digite o novo logradouro da hospedagem: ");
				logradouro = h.next();
				hosped.setLogradouro(logradouro);

				System.out.println("Digite o novo valor da hospedagem/diaria: ");
				valorHosped = h.nextDouble();
				hosped.setPrecoHosped(valorHosped);
				
				Hospedagem h2 = new Hospedagem(posicao, nome, tel, cidadeEstado, logradouro, valorHosped);

				hospedagemDAO.update(h2);

				System.out.println("\n**** Atualizou **** \n");

				break;

			case 4:

				// delete
				System.out.println("Digite o id da hospedagem para exclusao: ");

				try {
					posicao = h.nextInt();

					hospedagemDAO.deleteById(posicao);

				} catch (Exception e) {
					// e.getMessage();

					System.out.println(" Nenhum contato para excluir ");
				}

				break;
				
			case 5:

				System.out.println(" === Obrigado por usar nossa Agencia de Viagem === ");

				break;

			default:

				System.out.println("opção invalida, digite novamente.");
				
				break;
			}
			
		} while (opcao != 5);

		h.close();

	}
}