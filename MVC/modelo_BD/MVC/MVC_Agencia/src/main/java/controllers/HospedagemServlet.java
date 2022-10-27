package controllers;

	import java.io.IOException;
	import java.util.List;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import dao.HospedagemDAO;
	import model.Hospedagem;

	@WebServlet(urlPatterns = { "/hospedagem", "/hospedagens-create", "/hodpedagens-edit", "/hospedagens-update", "/hospedagens-delet" })
	public class HospedagemServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		HospedagemDAO hospedagemDAO = new HospedagemDAO();
		Hospedagem hospedagem = new Hospedagem();

		public HospedagemServlet() {
			super();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getServletPath();
			switch (action) {
			case "/hospedagem":
				read(request, response);
				break;
			case "/hospedagem-create":
				create(request, response);
				break;
			case "/hospedagem-edit":
				edit(request, response);
				break;
			case "/hospedagem-update":
				update(request, response);
				break;
			case "/hospedagem-delet":
				delet(request, response);
				break;

			default:
				response.sendRedirect("index.html");
				break;
			}
		}

		// READ
		protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			List<Hospedagem> lista = hospedagemDAO.getHospedagem();

			request.setAttribute("hospedagens", lista);

			RequestDispatcher rd = request.getRequestDispatcher("./views/hospedagem/index.jsp");
			rd.forward(request, response);
		}

		// CREATE
		protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			hospedagem.setNome(request.getParameter("nome_hospedagem"));
			hospedagem.setTel(request.getParameter("tel_hospedagem"));
			hospedagem.setCidadeEstado(request.getParameter("cidade_estado"));
			hospedagem.setLogradouro(request.getParameter("logradouro"));
			hospedagem.setPrecoHosped(Double.parseDouble(request.getParameter("preco_hospedagem")));

			hospedagemDAO.save(hospedagem);
			response.sendRedirect("hospedagens");

		}
		
		// READ BY ID
		protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));

			hospedagem = hospedagemDAO.getHospedagemById(id);

			request.setAttribute("id", hospedagem.getId());
			
			RequestDispatcher rd = request.getRequestDispatcher("./views/hospedagens/update.jsp");
			rd.forward(request, response);

		}
		
		// UPDATE
		protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			hospedagem.setId(Integer.parseInt(request.getParameter("id_hospedagem")));
			hospedagem.setNome(request.getParameter("nome_hospedagem"));
			hospedagem.setTel(request.getParameter("tel_hospedagem"));
			hospedagem.setCidadeEstado(request.getParameter("cidade_estado"));
			hospedagem.setLogradouro(request.getParameter("logradouro"));
			hospedagem.setPrecoHosped(Double.parseDouble(request.getParameter("preco_hospedagem")));

			hospedagemDAO.update(hospedagem);
			response.sendRedirect("hospedagens");
		}

		// DELET
		protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));

			hospedagemDAO.deleteById(id);
			response.sendRedirect("hospedagens");
		}

	}

