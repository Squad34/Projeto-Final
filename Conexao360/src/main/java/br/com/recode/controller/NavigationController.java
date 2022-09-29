package br.com.recode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.recode.model.Usuario;
import br.com.recode.dao.UsuarioDAO;

@Controller
public class NavigationController {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	Usuario usuario = new Usuario();

	@GetMapping("/")
    public String Home() {
        return "index";
    }
	
	
	@PostMapping("/cadastrarUsuario")
    public String CadastrarUsuario(@ModelAttribute Usuario usuario) {
		usuarioDAO.CadastrarUsuario(usuario);
        return "result";
    }
	
	@GetMapping("/cadastro")
    public String CadastroUsuario(final Model model) {
		model.addAttribute("usuario", new Usuario());
		return "cadastro-usuario";
    }
	
	@GetMapping("/cadastro-servico")
    public String CadastroServico(final Model model) {
       return "cadastro-servico";
    }
	
	@GetMapping("/cadastro-doacao")
    public String CadastroDoacao(final Model model) {
       return "cadastro-doacao";
    }
	
	@GetMapping("/cadastro-requisicao")
    public String CadastroRequisicao(final Model model) {
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
	
}
