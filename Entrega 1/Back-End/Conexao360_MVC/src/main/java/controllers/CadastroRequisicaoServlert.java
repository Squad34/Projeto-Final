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
import dao.RequisicaoDAO;
import model.Requisicao;

@WebServlet(urlPatterns = { "/requisicao", "/requisicao-create", "/requisicao-edit", "/requisicao-update",
		"/requisicao-delet" })
public class CadastroRequisicaoServelert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequisicaoDAO requisicaoDAO = new RequisicaoDAO();
	Requisicao requisicao = new Requisicao();

	public CadastroRequisicaoServelert() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/requisicao":
			read(request, response);
			break;
		case "/requisicao-create":
			create(request, response);
			break;
		case "/requisicao-edit":
			edit(request, response);
			break;
		case "/requisicao-update":
			update(request, response);
			break;
		case "/requisicao-delet":
			delet(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Requisicao> lista = requisicaoDAO.getRequisicao();
		request.setAttribute("requisicoes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/cadastro/cadastro-requisicao.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requisicao.setNecessidade(request.getParameter("necessidade"));
		requisicao.setTipoEquipamento(request.getParameter("tipoEquipamento"));
		requisicao.setPossuiEquipamento(request.getParameter("possuiEquipamento"));
		requisicao.setDivideEquipamento(request.getParameter("divideEquipamento"));
		requisicao.setRendaFamiliar(request.getParameter("rendaFamiliar"));
		requisicao.setNecessitaRetirada(request.getParameter("necessitaRetirada"));
		requisicao.setDataEntrega(request.getParameter("dataEntrega"));
		requisicao.setComentario(request.getParameter("comentario"));
		requisicaoDAO.saveRequisicao(requisicao);
		response.sendRedirect("requisicoes");
	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		requisicao = requisicaoDAO.getRequisicaoID(id);
		request.setAttribute("id", requisicao.getId());
		request.setAttribute("id_Usuario", requisicao.getIdUsuario());
		request.setAttribute("necessidade", requisicao.getNecessidade());
		request.setAttribute("tipoEquipamento", requisicao.getTipoEquipamento());
		request.setAttribute("possuiEquipamento", requisicao.getPossuiEquipamento());
		request.setAttribute("divideEquipamento", requisicao.getDivideEquipamento());
		request.setAttribute("rendaFamiliar", requisicao.getRendaFamiliar());
		request.setAttribute("necessitaRetirada", requisicao.getNecessitaRetirada());
		request.setAttribute("dataEntrega", requisicao.getDataEntrega());
		request.setAttribute("comentario", requisicao.getComentario());
		RequestDispatcher rd = request.getRequestDispatcher("./views/cadastro/cadastro-requisicao.jsp");
		rd.forward(request, response);
	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requisicao.setId(Integer.parseInt(request.getParameter("id")));
		requisicao.setIdUsuario(Integer.parseInt(request.getParameter("id_Usuario")));
		requisicao.setNecessidade(request.getParameter("necessidade"));
		requisicao.setTipoEquipamento(request.getParameter("tipoEquipamento"));
		requisicao.setPossuiEquipamento(request.getParameter("possuiEquipamento"));
		requisicao.setDivideEquipamento(request.getParameter("divideEquipamento"));
		requisicao.setRendaFamiliar(request.getParameter("rendaFamiliar"));
		requisicao.setNecessitaRetirada(request.getParameter("necessitaRetirada"));
		requisicao.setDataEntrega(request.getParameter("dataEntrega"));
		requisicao.setComentario(request.getParameter("comentario"));
		requisicaoDAO.updateRequisicao(requisicao);
		response.sendRedirect("requisicoes");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		requisicaoDAO.removeById(id);
		response.sendRedirect("requisicoes");
	}
}
