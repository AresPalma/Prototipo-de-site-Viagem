package CRUD;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import DAO.DestinoDAO;
import DAO.PassagemDAO;
import DAO.UsuariosDAO;
import modelo.Permissoes;
import modelo.Usuarios;
import modelo.Companhias;
import modelo.Destino;
import modelo.Hospedagem;
import modelo.Passagem;


public class Principal {
	
	public static void main(String args[]) {
		
		
	Usuarios usuario = new Usuarios();
	usuario.setNome("Francisco");
	usuario.setCpf("023982232-45");
	usuario.setTel("75-98443435262");
	usuario.setEmail("Monique@gmail");
	usuario.setSenha("123445");
	usuario.setPermissoes("comum");
	
	UsuariosDAO usuariosDAO = new UsuariosDAO();
	usuariosDAO.save(usuario);

	Permissoes p1 = new Permissoes(1, "comum");
	Permissoes p2 = new Permissoes(2, "admistrador");
	
	
	Usuarios u1 = new Usuarios(1, "Roberta","02342325612","759822323-2345", "roberta@email", "1234", p2);
	Usuarios u2 = new Usuarios(2, "Ana","02300225612","759800223-2345", "anna@email", " 4523", p1);
	Usuarios u3 = new Usuarios(3, "Jose","02003425612","759810223-8735", "jose@gmail", "2314", p1);
	
	
	Companhias c1 = new Companhias(4, "Atlas");
	Companhias c2 = new Companhias(6, "Tap");
	
	Hospedagem h1 = new Hospedagem(1, "Seara Praia Hotel", "8540112200","Fortaleza-CE","Av.Beira Mar 3080",411.00);

	System.out.println(u1.mostrar());
	System.out.println(u2.mostrar());
	System.out.println(u3.mostrar());
	
			
	Destino d = new Destino();
	d.setId(3);
	d.setNome("Salvador");
	d.setOrigem("Sao Paulo");
	d.setTipoDestino("Nacional-volta");
	d.setPrecoDestino(3000);

	DestinoDAO destinoDAO = new DestinoDAO();
	destinoDAO.update(d);


	 destinoDAO.deleteById(4);

		
	}
	

}



