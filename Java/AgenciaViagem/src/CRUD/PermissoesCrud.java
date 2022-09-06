package CRUD;


import java.util.Scanner;
import DAO.PermissoesDAO;
import modelo.Permissoes;


public class PermissoesCrud {

	public static void main(String[] args) {

	    Permissoes permissao = new Permissoes();
		PermissoesDAO permissaoDAO = new PermissoesDAO();

		Scanner perm = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;
				
		String tipo_permissao = "";
		

		do {

			System.out.println("----------------------------------");
			System.out.println("======== CRUD PERMISSOES =========");
			System.out.println("----------------------------------");
			System.out.println("-- 1 -- Cadastrar permissoes -----");
			System.out.println("-- 2 -- Consultar permissôes -----");
			System.out.println("-- 3 -- Atualizar permissôes -----");
			System.out.println("-- 4 -- Excluir  -----------------");
			System.out.println("-- 5 -- sair  ------------------\n");
			System.out.println("Selecione uma opção");
			System.out.println("-------------------------------\n");
			opcao = perm.nextInt();
		

			switch (opcao) {

			case 1:
				// CREATE
				System.out.println("Digite o tipo de permissao: ");
				tipo_permissao = perm.next();
				permissao.setTipo(tipo_permissao);
				
				permissaoDAO.save(permissao);
				
				break;
				
			case 2:
				// READ
				for (Permissoes p : permissaoDAO.getPermissoes()) {
					System.out.println("Id: " + p.getId() + " Tipo de Permissâo: " + p.getTipo());

					System.out.println("----------------------------------- ");					
				}

				System.out.println("consultou");

				break;

				case 3: 
					// UPDATE
				System.out.println("Digite o id da permissâo para atualizar: ");
				posicao = perm.nextInt();
				
				System.out.println("Digite o novo nome do contato: ");
				tipo_permissao = perm.next();
				permissao.setTipo(tipo_permissao);
				
				permissao.setId(posicao);

				permissaoDAO.update(permissao);
				
				System.out.println("atualizou");
			
				break;
			
				case 4 :
				// DELETE
				System.out.println("Digite o id da Permissao para exclusao: ");
				posicao = perm.nextInt();

				permissaoDAO.deleteById(posicao);

			case 5:

				System.out.println(" === Obrigado por usar nossa Agencia de Viagem === ");

				break;

			default:

				System.out.println("opção invalida, digite novamente.");

			}
		} while (opcao != 5);

		perm.close();

	}
}
