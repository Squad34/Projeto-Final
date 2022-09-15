import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

public class Principal {

	public static void main(String[] args) {
//		Conexão com o Banco de Dados
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuarioLogado = new Usuario();
		boolean logado = false;
		boolean master = false;
		// DestinoDAO destinoDAO = new DestinoDAO();
//		Captura dos dados digitados pelo usuário
		Scanner input = new Scanner(System.in);
		int menuPrincipal = 9;
		do {
			PrintMenuPrincipal();

			menuPrincipal = input.nextInt();

			switch (menuPrincipal) {
			case 1:
				CadastroUsuario(usuarioDAO, input);
				break;
			case 2:
				Login(usuarioDAO, input, logado, master);
				if (logado) {
					MenuUsuario(usuarioDAO, input, logado, master);
				}
				break;

			case 3:
				MenuUsuario(usuarioDAO, input, logado, master);
				break;
			case 0:
				System.out.println("Até breve.");
				break;
			default:
				break;
			}
		} while (menuPrincipal != 0);
		input.close();
	}

	// -------------------------------------------------
	// Menus
	// -------------------------------------------------
	public static void PrintMenuPrincipal() {
		System.out.println("------------------------------------------------");
		System.out.println("|                  Conexão 360                 |");
		System.out.println("------------------------------------------------");
		System.out.println("1 - Cadastrar Usuário");
		System.out.println("2 - Login");
		System.out.println("3 - Menu Usuario");
		System.out.println("0 - Sair");
	}

	public static void MenuUsuario(UsuarioDAO _usuarioDAO, Scanner _input, boolean _logado, boolean _master) {
		RequisicaoDAO requisicaoDAO = new RequisicaoDAO();
		int menuInterno = 9;
		do {
			System.out.println("------------------------------------------------");
			System.out.println("|                  Usuários                    |");
			System.out.println("------------------------------------------------");
			System.out.println("1 - Editar Usuário");
			System.out.println("2 - Doar Equipamento");
			System.out.println("3 - Requisitar Doação");
			System.out.println("4 - Meus equipamentos doados");
			System.out.println("5 - Minhas requisições de equipamento");
			// if(master) {
			System.out.println("6 - Menu Master User");
			// }
			System.out.println("0 - Voltar ao menu principal");

			menuInterno = _input.nextInt();

			switch (menuInterno) {
			case 1:
				EditarUsuario(_usuarioDAO, _input);
				break;
			case 2:
				ExcluirUsuario(_usuarioDAO, _input);
				break;
			case 3:
				FazerRequisicao(requisicaoDAO, _input);
				break;
			case 4:
				BuscarUsuarioNome(_usuarioDAO, _input);
				break;
			case 5:
				BuscarUsuarioID(_usuarioDAO, _input);
				break;
			case 0:
				System.out.println("Voltando ao menu principal.");
				break;
			default:
				break;
			}
		} while (menuInterno != 0);

	}
	// -------------------------------------------------
	// Cadastro Usuário
	// -------------------------------------------------

	public static Usuario CriarUsuario(UsuarioDAO _usuarioDAO, Scanner _input) {
		boolean validacao = false;
		Usuario usuario = new Usuario();
		// Cadastra o nome do Usuário, usando a função que permite que o input capture
		// espaço.
		System.out.println("Digite o nome que deseja cadastrar:");
		usuario.setNome(CapturarString(_input));

		System.out.println("Qual seu sexo:");
		usuario.setSexo(CapturarString(_input));

		CadastrarRG(usuario, _usuarioDAO, _input);
		CadastrarCPF(usuario, _usuarioDAO, _input);
		CadastrarDataNascimento(usuario, _usuarioDAO, _input);

		do {
			System.out.println("Digite o email:");
			String email = _input.next();
			validacao = VerificarEmail(email, _usuarioDAO);
			usuario.setEmail(email);
		} while (!validacao);

		System.out.println("Digite a senha:");
		usuario.setSenha(_input.next());

		System.out.println("Digite o telefone:");
		usuario.setTelefone(_input.next());

		System.out.println("Digite o Estado:");
		usuario.setEstado(_input.next());

		System.out.println("Digite o CEP:");
		usuario.setCEP(_input.next());

		System.out.println("Digite o endereço:");
		usuario.setEndereco(CapturarString(_input));

		System.out.println("Digite o Complemento(opcional):");
		usuario.setComplemento(CapturarString(_input));

		return usuario;

	}

	public static void PrintUsuario(Usuario u) {
		System.out.println("Id: " + u.getId());
		System.out.println("NOME: " + u.getNome());
		System.out.println("Sexo: " + u.getSexo());
		System.out.println("RG: " + u.getRG());
		System.out.println("CPF: " + u.getCPF());
		System.out.println("DATA DE NASCIMENTO: " + u.getDataNascimento());
		System.out.println("E-MAIL: " + u.getEmail());
		System.out.println("TELEFONE: " + u.getTelefone());
		System.out.println("ESTADO: " + u.getEstado());
		System.out.println("CEP: " + u.getCEP());
		System.out.println("ENDEREÇO: " + u.getEndereco());
		System.out.println("COMPLEMENTO: " + u.getEndereco());
		System.out.println("----------------------------------- ");
	}

	public static void CadastroUsuario(UsuarioDAO _usuarioDAO, Scanner _input) {
		Usuario usuario = CriarUsuario(_usuarioDAO, _input);
		_usuarioDAO.saveUsuario(usuario);
	}

	public static void FazerRequisicao(RequisicaoDAO _requisicaoDAO, Scanner _input) {
		Requisicao requisicao = CriarRequisicao(_requisicaoDAO, _input);
		_requisicaoDAO.saveRequisicao(requisicao);
	}

	public static Requisicao CriarRequisicao(RequisicaoDAO _requisicaoDAO, Scanner _input) {
		boolean validacao = false;
		boolean necessitaRetirada;
		Requisicao requisicao = new Requisicao();

		System.out.println("Qual a necessidade do Equipamento?");
		System.out.println("1-");
		System.out.println("2-");
		System.out.println("3-");
		System.out.println("4-");
		requisicao.setNecessidade(_input.nextInt());

		System.out.println("Qual o tipo do Equipamento?");
		System.out.println("1-");
		System.out.println("2-");
		System.out.println("3-");
		System.out.println("4-");
		requisicao.setTipoEquipamento(_input.nextInt());

		System.out.println("Possui Equipamento em casa (S/N)?");
		System.out.println("1-");
		System.out.println("2-");
		requisicao.setPossuiEquipamento(_input.nextBoolean());

		System.out.println("Divide Equipamento(S/N)?");
		System.out.println("1-");
		System.out.println("2-");
		requisicao.setDivideEquipamento(_input.nextBoolean());

		System.out.println("Qual a Renda Familiar?");
		requisicao.setRendaFamiliar(_input.nextInt());

		System.out.println("Necessita que retire o equipamento em casa(S/N)?");
		necessitaRetirada = _input.nextBoolean();
		requisicao.setDivideEquipamento(necessitaRetirada);

		String data = "13/09/2022";
		Date dataEntr = new Date();
		try {
			dataEntr = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		requisicao.setDataEntrega(dataEntr);

		requisicao.setCEPEntrega("00000-000");
		requisicao.setEstadoEntrega("SP");
		requisicao.setCidadeEntrega("São Paulo");
		requisicao.setEnderecoEntrega("Rua Jorge, 99");
		requisicao.setComplemento("Blabla");
		requisicao.setComentario("bleble");
		requisicao.setIdUsuario(1);

		return requisicao;
	}

	public static void BuscarUsuario(UsuarioDAO _usuarioDAO) {
		for (Usuario u : _usuarioDAO.getUsuario()) {
			PrintUsuario(u);
		}
	}

	public static void ExcluirUsuario(UsuarioDAO _usuarioDAO, Scanner _input) {
		int numDigitado;
		System.out.println("Digite o ID do usuario que deseja excluir:");
		numDigitado = _input.nextInt();
		_usuarioDAO.removeById(numDigitado);
	}

	public static void EditarUsuario(UsuarioDAO _usuarioDAO, Scanner _input) {
		System.out.println("Digite o ID do usuário que deseja alterar:");
		int id = _input.nextInt();

		Usuario usuario = CriarUsuario(_usuarioDAO, _input);
		usuario.setId(id);
		_usuarioDAO.updateUsuario(usuario);
	}

	public static void BuscarUsuarioNome(UsuarioDAO _usuarioDAO, Scanner _input) {
		System.out.println("Digite o nome que deseja buscar:");
		String nomeBuscado = CapturarString(_input);
		boolean encontrado = false;
		for (Usuario u : _usuarioDAO.getUsuariosNome(nomeBuscado)) {
			if (u.getNome() != null && u.getNome().contains(nomeBuscado)) {
				PrintUsuario(u);
				encontrado = true;
			}
		}
		if (encontrado == false) {
			System.out.println("Cliente não encontrado");
		}
	}

	public static void BuscarUsuarioID(UsuarioDAO _usuarioDAO, Scanner _input) {
		System.out.println("Digite o ID que deseja buscar:");
		int idBuscado = _input.nextInt();
		boolean encontrado = false;
		Usuario u = _usuarioDAO.getUsuarioID(idBuscado);
		if (u.getId() != 0) {
			PrintUsuario(u);
			encontrado = true;
		}
		if (encontrado == false) {
			System.out.println("ID não encontrado");
		}
	}

	public static String CapturarString(Scanner inputInterno) {
		String stringEspaco = inputInterno.nextLine();
		stringEspaco += inputInterno.next();
		return stringEspaco;
	}

	public static Boolean VerificarEmail(String _email, UsuarioDAO _usuarioDAO) {
		String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
				+ "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";
		Pattern pat = Pattern.compile(emailRegex);
		if (_email == null) {
			System.out.println("O e-mail não pode ser nulo");
			return false;
		}

		if (!pat.matcher(_email).matches()) {
			System.out.println("Formato de e-mail inválido");
			return false;
		}

		if (_usuarioDAO.getUsuarioEmail(_email)) {
			System.out.println("O e-mail já está cadastrado");
			return false;
		}

		return true;
	}

	// CPF

	public static void CadastrarCPF(Usuario _usuario, UsuarioDAO _usuarioDAO, Scanner _input) {
		boolean validacao = false;
		do {
			System.out.println("Digite o CPF:");
			String CPF = _input.next();
			validacao = VerificarCPF(CPF, _usuario, _usuarioDAO);
			if (!validacao) {
				System.out.println("CPF Inválido");
			}
		} while (!validacao);
		validacao = false;
	}

	public static Boolean VerificarCPF(String _CPF, Usuario _usuario, UsuarioDAO _usuarioDAO) {
		if (_CPF == null) {
			System.out.println("O CPF não pode ser nulo");
			return false;
		}

		String cleanCPF = _CPF.replaceAll("[^0-9]", "");

		if (cleanCPF.length() < 11) {
			return false;
		}

		_CPF = cleanCPF.replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4");

		if (_usuarioDAO.getUsuarioCPF(_CPF)) {
			System.out.println("O CPF já está cadastrado");
			return false;
		}
		_usuario.setCPF(_CPF);
		return true;
	}

	// Data Nascimento

	public static void CadastrarDataNascimento(Usuario _usuario, UsuarioDAO _usuarioDAO, Scanner _input) {
		boolean validacao = false;
		do {
			System.out.println("Digite a data de nascimento:");
			String dataNasc = _input.next();
			validacao = VerificarDataNascimento(dataNasc, _usuario, _usuarioDAO);
			if (!validacao) {
				System.out.println("Data invalida");
			}
		} while (!validacao);
		validacao = false;
	}

	public static Boolean VerificarDataNascimento(String _dataNasc, Usuario _usuario, UsuarioDAO _usuarioDAO) {
		Date dataNasc = new Date();
		if (_dataNasc == null) {
			System.out.println("O CPF não pode ser nulo");
			return false;
		}

		String DataLimpa = _dataNasc.replaceAll("[^0-9]", "");
		_dataNasc = DataLimpa.replaceAll("([0-9]{1,2})([0-9]{2})([0-9]{4})", "$1/$2/$3");
		System.out.println("Antes: " + _dataNasc);
		switch (_dataNasc.length()) {
		case 5:
			_dataNasc = "0" + _dataNasc;
		case 6:
			try {
				dataNasc = new SimpleDateFormat("dd/MM/yy").parse(_dataNasc);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 7:
			_dataNasc = "0" + _dataNasc;
		case 8:
			try {
				dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(_dataNasc);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

		System.out.println(dataNasc);

		_usuario.setDataNascimento(dataNasc);
		return true;
	}

	// RG
	public static void CadastrarRG(Usuario _usuario, UsuarioDAO _usuarioDAO, Scanner _input) {
		boolean validacao = false;
		do {
			System.out.println("Digite o RG:");
			String RG = _input.next();
			validacao = VerificarRG(RG, _usuario, _usuarioDAO);
			if (!validacao) {
				System.out.println("RG Inválido");
			}
		} while (!validacao);
		validacao = false;
	}

	public static Boolean VerificarRG(String _RG, Usuario _usuario, UsuarioDAO _usuarioDAO) {
		if (_RG == null) {
			System.out.println("O RG não pode ser nulo");
			return false;
		}

		String cleanRG = _RG.replaceAll("[^0-9]", "");
		switch (cleanRG.length()) {
		case 7:
			_RG = cleanRG.replaceAll("([0-9]{1})([0-9]{3})([0-9]{3})", "$1.$2.$3");
			break;
		case 8:
			_RG = cleanRG.replaceAll("([0-9]{1})([0-9]{3})([0-9]{3})", "$1.$2.$3-");
			break;
		case 9:
			_RG = cleanRG.replaceAll("([0-9]{2})([0-9]{3})([0-9]{3})", "$1.$2.$3-");
			break;
		default:
			return false;

		}

		if (_usuarioDAO.getUsuarioRG(_RG)) {
			System.out.println("O RG já está cadastrado");
			return false;
		}
		System.out.println(_RG);
		_usuario.setRG(_RG);
		return true;
	}

	public static void Login(UsuarioDAO _usuarioDAO, Scanner _input, boolean _logado, boolean _master) {
		System.out.println("Digite o e-mail cadastrado");
		String email = _input.next();

		System.out.println("Digite a senha.");
		String senha = _input.next();

		if (_usuarioDAO.Login(email, senha)) {
			_logado = true;
			System.out.println("Usuario autenticado, login realizado");
		} else {
			_logado = false;
			System.out.println("e-mail ou senha incorretos");
		}

	}

	// ESTADO
	public static void CadastrarEstado(Usuario _usuario, UsuarioDAO _usuarioDAO, Scanner _input) {
		boolean validacao = false;
		do {
			System.out.println("Escolha o seu Estado:");
			String estado = _input.next();
			validacao = VerificarEstado(estado, _usuario, _usuarioDAO);
			if (!validacao) {
				System.out.println("Estado Inválido");
			}
		} while (!validacao);
		validacao = false;
	}

	private static boolean VerificarEstado(String _estado, Usuario _usuario, UsuarioDAO _usuarioDAO) {

		if (_estado == null) {
			System.out.println("O Estado não pode ser nulo");
			return false;
		}

		_estado.toUpperCase();

		if (_estado.length() != 2) {
			System.out.println("O Estado não é válido");
			return false;
		}

		String[] estado = { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
				"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SP", "SE", "TO" };
		for (int i = 0; i < estado.length; i++) {
			if (_estado.equals(estado[i])) {
				_usuario.setEstado(_estado);
				return true;
			}
		}
		return false;
	}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	// CEP
	public static void CadastrarCEP(Usuario _usuario, UsuarioDAO _usuarioDAO, Scanner _input) {
		boolean validacao = false;
		do {
			System.out.println("Digite o seu CEP:");
			String cep = _input.next();
			validacao = VerificarCEP(cep, _usuario, _usuarioDAO);
			if (!validacao) {
				System.out.println("CEP Inválido");
			}
		} while (!validacao);
		validacao = false;
	}

	private static boolean VerificarCEP(String _cep, Usuario _usuario, UsuarioDAO _usuarioDAO) {
		if (_cep == null) {
			System.out.println("O CEP não pode ser nulo");
			return false;
		}
		String cleanCEP = _cep.replaceAll("[^0-9]", "");
		if (cleanCEP.length() != 8) {
			System.out.println("O CEP inválido");
			return false;
		}
		
		
		cleanCEP = cleanCEP.substring(0, 4) + "-" + cleanCEP.substring(5, 7);
		
		
		
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}