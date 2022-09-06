package CRUD;

import java.util.Scanner;

import DAO.DestinoDAO;
import DAO.HospedagemDAO;
import DAO.PassagemDAO;
import DAO.UsuariosDAO;
import modelo.Destino;
import modelo.Hospedagem;
import modelo.Passagem;
import modelo.Usuarios;

public class PassagemCrud {

	public static void main(String[] args) {

		UsuariosDAO usuariosDAO = new UsuariosDAO();
		PassagemDAO passagemDAO = new PassagemDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		HospedagemDAO hospedDAO = new HospedagemDAO();

		Scanner p = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String tipoPacote = "";
		String dataEmbarque = "";
		String dataRetorno = "";
		String Qtd_dias = "";
		double precoCompra = 0;

		int id_usuario = 0;
		int id_destino = 0;
		int id_hospedagem = 0;

		do {

			System.out.println("----------------------------------");
			System.out.println("=========== CRUD DESTINO =========");
			System.out.println("----------------------------------");
			System.out.println("-- 1 ---- Cadastrar passagem -----");
			System.out.println("-- 2 ---- Consultar Passagem -----");
			System.out.println("-- 3 ---- Atualizar Passagem -----");
			System.out.println("-- 4 ---- Excluir  ---------------");
			System.out.println("-- 5 ---- sair  ----------------\n");
			System.out.println("Selecione uma opção");
			System.out.println("--------------------------------\n");
			opcao = p.nextInt();
			p.nextLine();

			switch (opcao) {

			case 1:
				// CREATE
				System.out.println("Digite o id da passagem: ");
				posicao = p.nextInt();
				p.nextLine();
				System.out.println("Digite o tipo de pacote: ");
				tipoPacote = p.nextLine();
				System.out.println("Digite a data de embarque: ");
				dataEmbarque = p.nextLine();
				System.out.println("Digite a data de retorno: ");
				dataRetorno = p.nextLine();
				System.out.println("Digite a quantidade de dias: ");
				Qtd_dias = p.nextLine();
				System.out.println("Valor do pacote: ");
				precoCompra = p.nextDouble();
				p.nextLine();
				System.out.println("Digite o id da hospedagem: ");
				id_hospedagem = p.nextInt();
				System.out.println("Digite o id do destino: ");
				id_destino = p.nextInt();
				p.nextLine();

				Usuarios usuarios = usuariosDAO.getUsuariosById(id_usuario);
				Hospedagem hospedagem = hospedDAO.getHospedagemById(id_hospedagem);
				Destino destino = destinoDAO.getDestinoById(id_destino);

				Passagem p1 = new Passagem(id, tipoPacote, dataEmbarque, dataRetorno, Qtd_dias, precoCompra, usuarios,
						hospedagem, destino);

				passagemDAO.save(p1);

				System.out.println("\n***  Cadastrou  ***\n");

				break;

			case 2:

				// READ
				for (Passagem p2 : passagemDAO.getPassagem()) {

					System.out.println("Nome do usuario: " + p2.getUsuarios().getNome());
					System.out.println("Tipo de Pacote: " + p2.getTipoPacote());
					System.out.println("Data de embarque: " + p2.getDataEmbarque());
					System.out.println("Data de embarque: " + p2.getDataRetorno());
					System.out.println("Destino: " + p2.getDestino().getNome());
					System.out.println("Hospedagem: " + p2.getHospedagem().getNome());
					System.out.println("Qqt. de dias: " + p2.getQtd_dias());
					System.out.println("Valor do pacote: " + p2.getPrecoCompra());

					System.out.println("----------------------------------- ");
				}

				System.out.println("\n**** Consultou **** \n");

				break;

			case 3:
				// UPDATE

				System.out.println("Digite o id da passagem: ");
				posicao = p.nextInt();
				p.nextLine();
				System.out.println(" tipo de pacote: ");
				tipoPacote = p.nextLine();
				System.out.println("Digite a data de embarque: ");
				dataEmbarque = p.nextLine();
				System.out.println("Digite a data de retorno: ");
				dataRetorno = p.nextLine();
				System.out.println("Digite a quantidade de dias: ");
				Qtd_dias = p.nextLine();
				System.out.println("Digite o id da hospedagem: ");
				id_hospedagem = p.nextInt();
				p.nextLine();
				System.out.println("Digite o id do destino: ");
				id_destino = p.nextInt();
				p.nextLine();
				System.out.println("Valor do Pacote: ");
				precoCompra = p.nextDouble();
				p.nextLine();

				Usuarios usuario1 = usuariosDAO.getUsuariosById(id_usuario);
				Hospedagem hosped1 = hospedDAO.getHospedagemById(id_hospedagem);
				Destino destino2 = destinoDAO.getDestinoById(id_destino);

				Passagem p2 = new Passagem(posicao, tipoPacote, dataEmbarque, dataRetorno, Qtd_dias, precoCompra,
						usuario1, hosped1, destino2);

				passagemDAO.update(p2);

				System.out.println("\n**** Atualizou **** \n");
				break;

			case 4:
				// DELETE
				System.out.println("Digite o id da passagem: ");
				posicao = p.nextInt();

				passagemDAO.deleteById(posicao);

				break;

			case 5:
				// Sair
				System.out.println(" === Obrigado por usar nossa Agencia de Viagem === ");

				break;

			default:

				System.out.println("opção invalida, digite novamente.");
				break;
			}

		} while (opcao != 5);

		p.close();

	}
}