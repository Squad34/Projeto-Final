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
import dao.DoacaoDAO;
import model.Doacao;

@WebServlet(urlPatterns = { "/doacao", "/doacao-create", "/doacao-edit", "/doacao-update", "/doacao-delet" })
public class CadastroDoacaoServelert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DoacaoDAO doacaoDAO = new DoacaoDAO();
	Doacao doacao = new Doacao();

	public CadastroDoacaoServelert() {
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
		List<Doacao> lista = doacaoDAO.getListaDoacoes();
		request.setAttribute("doacoes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/cadastro/cadastro-doacao.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doacao.setTipoEquipamento(request.getParameter("tipoEquipamento"));
		doacao.setEstadoEquipamento(request.getParameter("estadoEquipamento"));
		doacao.setTipoColeta(request.getParameter("tipoColeta"));
		doacao.setDataColeta(request.getParameter("dataColeta"));
		doacao.setEquipamentoDisponivel(request.getParameter("equipamentoDisponivel"));
		doacao.setEquipamentoDoado(request.getParameter("equipamentoDoado"));
		doacao.setComentario(request.getParameter("comentario"));
		doacaoDAO.saveDoacao(doacao);
		response.sendRedirect("doacoes");
	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		doacao = doacaoDAO.getDoacaoID(id);
		request.setAttribute("id", doacao.getId());
		request.setAttribute("id_Usuario", doacao.getIdUsuario());
		request.setAttribute("tipoEquipamento", doacao.getTipoEquipamento());
		request.setAttribute("estadoEquipamento", doacao.getEstadoEquipamento());
		request.setAttribute("tipoColeta", doacao.getTipoColeta());
		request.setAttribute("dataColeta", doacao.getDataColeta());
		request.setAttribute("equipamentoDisponivel", doacao.getEquipamentoDisponivel());
		request.setAttribute("comentario", doacao.getComentario());
		RequestDispatcher rd = request.getRequestDispatcher("./views/cadastro/cadastro-doacao.jsp");
		rd.forward(request, response);
	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doacao.setId(Integer.parseInt(request.getParameter("id")));
		doacao.setIdUsuario(Integer.parseInt(request.getParameter("id_Usuario")));
		doacao.setTipoEquipamento(request.getParameter("tipoEquipamento"));
		doacao.setEstadoEquipamento(request.getParameter("estadoEquipamento"));
		doacao.setTipoColeta(request.getParameter("tipoColeta"));
		doacao.setDataColeta(request.getParameter("dataColeta"));
		doacao.setEquipamentoDisponivel(request.getParameter("equipamentoDisponivel"));
		doacao.setEquipamentoDoado(request.getParameter("equipamentoDoado"));
		doacao.setComentario(request.getParameter("comentario"));
		doacaoDAO.updateDoacao(doacao);
		response.sendRedirect("doacoes");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		doacaoDAO.removeById(id);
		response.sendRedirect("doacoes");
	}
}
