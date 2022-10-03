package br.com.recode.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.recode.dao.DoacaoDAO;
import br.com.recode.dao.RequisicaoDAO;
import br.com.recode.dao.UsuarioDAO;
import br.com.recode.model.Doacao;
import br.com.recode.model.Requisicao;
import br.com.recode.model.Usuario;

@Controller
public class NavigationController {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	DoacaoDAO doacaoDAO = new DoacaoDAO();
	RequisicaoDAO requisicaoDAO = new RequisicaoDAO();
	Usuario usuarioLogado;

	@GetMapping("/")
    public String Home() {
        return "index";
    }
	
	@PostMapping("/cadastrarUsuario")
    public String CadastrarUsuario(@ModelAttribute Usuario usuario) {
		usuarioDAO.CadastrarUsuario(usuario);
        return "index";
    }
	
	@PostMapping("/alterarUsuario")
    public String AlterarUsuario(@ModelAttribute Usuario usuario) {
		usuario.setId(usuarioLogado.getId());
		usuarioDAO.updateUsuario(usuario);
        return "cadastro-servico";
    }
	
	@PostMapping("/cadastrarDoacao")
    public String CadastrarDoacao(@ModelAttribute Doacao doacao) {
		doacao.setIdUsuario(usuarioLogado.getId());
		doacao.setEquipamentoDoado(false);
		doacao.setEquipamentoDisponivel(true);
		doacaoDAO.CadastrarDoacao(doacao);
        return "redirect:cadastro-doacao-servico";
    }
	
	@PostMapping("/cadastrarRequisicao")
    public String CadastrarRequisicao(@ModelAttribute Requisicao requisicao) {
		requisicao.setIdUsuario(usuarioLogado.getId());
		requisicaoDAO.CadastrarRequisicao(requisicao);
        return "redirect:cadastro-requisicao-servico";
    }
	
	@GetMapping("/deletarRequisicao")
    public String DeletarRequisicao(String id) {
		int i = Integer.parseInt(id);
		System.out.println("ID Requisicao = " + id);
		requisicaoDAO.removeById(i);
        return "redirect:cadastro-requisicao-servico";
    }
	
	@GetMapping("/deletarDoacao")
    public String DeletarDoacao(String id) {
		int i = Integer.parseInt(id);
		doacaoDAO.removeById(i);
        return "redirect:cadastro-doacao-servico";
    }
	
	@GetMapping("/login")
    public String Login(final Model model) {
		System.out.println("Entrou na página de Login");
		if(usuarioLogado == null) {
			model.addAttribute("usuario", new Usuario());
			return "login";
		} else {
			return "redirect:cadastro-servico";
		}
    }
	
	@PostMapping("/logar")
    public String LogarUsuario(@ModelAttribute Usuario usuario) {
		System.out.println("Clicou em logar");
		if(usuarioDAO.Login(usuario.getEmail(),usuario.getSenha())) {
			usuarioLogado = usuarioDAO.BuscarUsuarioEmail(usuario.getEmail());	
							
			return "redirect:cadastro-servico";
		} else {
			System.out.println("Usuario ou senha incorretos");
			return "redirect:login";
		}
	}
	
	@GetMapping("/cadastro-servico")
    public String CadastroServico(final Model model) {
		System.out.println("Entrou no cadastro-servico");
		System.out.println(usuarioLogado);
		model.addAttribute("usuarioLogado",usuarioLogado);
		return "cadastro-servico";
    }
	

	
	@GetMapping("/cadastro")
    public String CadastroUsuario(final Model model) {
		model.addAttribute("usuario", new Usuario());
		return "cadastro-usuario";
    }
	

	
	@GetMapping("/cadastro-doacao")
    public String CadastroDoacao(final Model model) {
		model.addAttribute("doacao", new Doacao());
       return "cadastro-doacao";
    }
	
	@GetMapping("/cadastro-requisicao")
    public String CadastroRequisicao(final Model model) {
		model.addAttribute("requisicao", new Requisicao());
       return "cadastro-requisicao";
    }
	
	@GetMapping("/contato")
    public String Contato(final Model model) {
       return "contato";
    }
	
	@GetMapping("/sobre")
    public String Sobre(final Model model) {
       return "sobre";
    }
	
	@GetMapping("/logout")
    public String Logout(@ModelAttribute Usuario usuario) {
		usuarioLogado = null;
		return "index";
	}
	
	@GetMapping("/cadastro-doacao-servico")
	public String CadastroDoacaoServico(final Model model) {
		List<Doacao> doacoes = doacaoDAO.getListaDoacoes(usuarioLogado.getId());
		model.addAttribute("doacoes", doacoes);
		return "cadastro-doacao-servico";
	}
	
	@GetMapping("/cadastro-requisicao-servico")
	public String CadastroRequisicaoServico(final Model model) {
		List<Requisicao> requisicoes = requisicaoDAO.getRequisicao(usuarioLogado.getId());
		model.addAttribute("requisicoes", requisicoes);
		return "cadastro-requisicao-servico";
	}
	
	@GetMapping("/alterarUsuario")
    public String AlterarUsuario(final Model model) {
		model.addAttribute("usuario", usuarioLogado);
		return "alterar-usuario";
    }
}
