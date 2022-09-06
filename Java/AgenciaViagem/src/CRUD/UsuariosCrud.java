package CRUD;


import java.util.Scanner;

import DAO.PermissoesDAO;
import DAO.UsuariosDAO;
import modelo.Permissoes;
import modelo.Usuarios;

public class UsuariosCrud {
	public static void main(String[] args) {

		UsuariosDAO userDAO = new UsuariosDAO();
		Usuarios usuario = new Usuarios();
		PermissoesDAO permissaoDAO = new PermissoesDAO();

		Scanner user = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";
		String cpf = "";
		String tel_usuario = "";
		String email = "";
		String senha = "";
		int id_permissao = 0;

		do {

			System.out.println("---------------------------------");
			System.out.println("========== CRUD USUARIO =========");
			System.out.println("---------------------------------");
			System.out.println("-- 1 ---- Cadastrar Usuario -----");
			System.out.println("-- 2 ---- Consultar Usuario -----");
			System.out.println("-- 3 ---- Atualizar Usuario -----");
			System.out.println("-- 4 ---- Excluir  --------------");
			System.out.println("-- 5 ---- sair  ---------------\n");
			System.out.println("Selecione uma opção");
			System.out.println("-------------------------------\n");
			opcao = user.nextInt();
			user.nextLine();

			switch (opcao) {

			case 1:

				// CREATE
				System.out.println("Digite o nome do Usuario: ");
				nome = user.nextLine();
				usuario.setNome(nome);
				System.out.println("Digite a CPF do Usuario: ");
				cpf = user.nextLine();
				System.out.println("Digite o telefone ou celular do Usuario: ");
				tel_usuario = user.nextLine();
				System.out.println("Digite o e-mail do Usuario: ");
				email = user.nextLine();
				System.out.println("Digite a senha: ");
				senha = user.nextLine();
				System.out.println("Digite o id da permissao: ");
				id_permissao = user.nextInt();
				user.nextLine();

				Permissoes permissao = permissaoDAO.getPermissaoById(id_permissao);

				Usuarios user1 = new Usuarios(id, nome, cpf, tel_usuario, email, senha, permissao);

				userDAO.save(user1);

				System.out.println("\n***  Cadastrou  ***\n");

				break;

			case 2:

				// READ
				for (Usuarios u : userDAO.getUsuarios()) {
					System.out.println("Id: " + u.getId() + " Nome: " + u.getNome() + " Tipo de permissão: "
							+ u.getPermissoes().getTipo());
				}

				System.out.println("\n**** Consultou **** \n");

				break;

			case 3:

				// UPDATE
				System.out.println("Digite o id do Usuario para atualizar: ");
				posicao = user.nextInt();
				user.nextLine();
				System.out.println("Digite o novo nome do Usuario: ");
				nome = user.nextLine();
				usuario.setNome(nome);
				System.out.println("Digite a CPF do Usuario: ");
				cpf = user.nextLine();
				System.out.println("Digite o novo telefone ou celular do Usuario: ");
				tel_usuario = user.nextLine();
				System.out.println("Digite o novo  e-mail do Usuario: ");
				email = user.nextLine();
				System.out.println("Digite a senha: ");
				senha = user.nextLine();
				System.out.println("Digite o id da permissao: ");
				id_permissao = user.nextInt();
				user.nextLine();

				Permissoes permissao1 =  new Permissoes();

				Usuarios u2 = new Usuarios(posicao, nome, cpf, tel_usuario, email, senha, permissao1);

				userDAO.update(u2);

				System.out.println("\n**** Atualizou **** \n");
				break;

			case 4:
				// DELETE
				System.out.println("Digite o id do Usuario para exclusao: ");
				posicao = user.nextInt();

				userDAO.removeById(posicao);

			case 5:

				System.out.println(" === Obrigado por usar nossa Agencia de Viagem === ");

				break;

			default:

				System.out.println("opção invalida, digite novamente.");
				
				break;

			}
		} while (opcao != 5);

		user.close();

	}
}