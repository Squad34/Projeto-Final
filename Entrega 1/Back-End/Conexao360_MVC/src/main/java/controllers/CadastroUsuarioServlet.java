package controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet(urlPatterns = { "/usuario", "/usuario-create", "/usuario-edit", "/usuario-update", "/usuario-delet" })
public class CadastroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDAO usuarioDAO = new UsuarioDAO();
	Usuario usuario = new Usuario();

	public CadastroUsuarioServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/usuario":
			read(request, response);
			break;
		case "/usuario-create":
			create(request, response);
			break;
		case "/usuario-edit":
			edit(request, response);
			break;
		case "/usuario-update":
			update(request, response);
			break;
		case "/usuario-delet":
			delet(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}
	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> lista = usuarioDAO.getUsuario();
		request.setAttribute("usuarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/cadastro/cadastro-usuario.jsp");
		rd.forward(request, response);
	}
	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.setNome(request.getParameter("nome"));
		usuario.setRG(request.getParameter("rg"));
		usuario.setCPF(request.getParameter("cpf"));
		usuario.setDataNascimento(request.getParameter("DataNascimento"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setEstado(request.getParameter("estado"));
		usuario.setCidade(request.getParameter("cidade"));
		usuario.setCEP(request.getParameter("cep"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setComplemento(request.getParameter("complemento"));
		usuario.setMasterUser(request.getParameter("administrador"));
		usuarioDAO.saveUsuario(usuario);
		response.sendRedirect("usuarios");
	}
	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		usuario = usuarioDAO.getUsuarioID(id);
		request.setAttribute("id", usuario.getId());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("rg", usuario.getRG());
		request.setAttribute("cpf", usuario.getCPF());
		request.setAttribute("DataNascimento", usuario.getDataNascimento());
		request.setAttribute("email", usuario.getEmail());
		request.setAttribute("telefone", usuario.getTelefone());
		request.setAttribute("estado", usuario.getEstado());
		request.setAttribute("cidade", usuario.getCidade());
		request.setAttribute("cep", usuario.getCEP());
		request.setAttribute("endereco", usuario.getEndereco());
		request.setAttribute("complemento", usuario.getComplemento());
		request.setAttribute("administrador", usuario.getAdministrador());
		RequestDispatcher rd = request.getRequestDispatcher("./views/cadastro/cadastro-usuario.jsp");
		rd.forward(request, response);

	}
	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNome(request.getParameter("nome"));
		usuario.setRG(request.getParameter("rg"));
		usuario.setCPF(request.getParameter("cpf"));
		usuario.setDataNascimento(request.getParameter("DataNascimento"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setEstado(request.getParameter("estado"));
		usuario.setCidade(request.getParameter("cidade"));
		usuario.setCEP(request.getParameter("cep"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setComplemento(request.getParameter("complemento"));
		usuario.setMasterUser(request.getParameter("administrador"));
		usuarioDAO.updateUsuario(usuario);
		response.sendRedirect("usuarios");
	}
	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		usuarioDAO.removeById(id);
		response.sendRedirect("usuarios");
	}
}
