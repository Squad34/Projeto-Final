import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Principal {

	public static void main(String[] args) {
//		Conexão com o Banco de Dados
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		boolean logado = false;
		boolean master = false;
		//DestinoDAO destinoDAO = new DestinoDAO();
//		Captura dos dados digitados pelo usuário
		Scanner input = new Scanner(System.in);	
		int menuPrincipal=9;
		do {
			PrintMenuPrincipal();
			
			menuPrincipal = input.nextInt();

			switch(menuPrincipal) {
			case 1:
				CadastroUsuario(usuarioDAO, input);
				break;
			case 2:
				Login(usuarioDAO, input, logado, master);
				if(logado) {
					MenuCliente(usuarioDAO, input, logado, master);
				}
				break;
			case 0:
				System.out.println("Até breve.");
				break;
			default:
				break;
			}
		}while(menuPrincipal != 0);
		input.close();
	}
	
	public static void PrintMenuPrincipal() {
		System.out.println("------------------------------------------------");
		System.out.println("|                  Conexão 360                 |");
		System.out.println("------------------------------------------------");
		System.out.println("1 - Cadastrar Usuário");
		System.out.println("2 - Login");
		System.out.println("0 - Sair");
	}
	
	public static void MenuCliente(UsuarioDAO _usuarioDAO, Scanner _input, boolean _logado, boolean _master) {
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
			//if(master) {
				System.out.println("6 - Menu Master User");
			//}
			System.out.println("0 - Voltar ao menu principal");
			
			menuInterno = _input.nextInt();

			switch(menuInterno) {
			case 1:
				EditarUsuario(_usuarioDAO, _input);
				break;
			case 2:
				ExcluirUsuario(_usuarioDAO, _input);
				break;
			case 3:
				BuscarUsuario(_usuarioDAO);
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
		}while(menuInterno != 0);
		
	}

	//Cliente
	
	public static Usuario CriarUsuario(UsuarioDAO _usuarioDAO, Scanner _input) {
		boolean validacao = false;
		Usuario usuario = new Usuario();
		System.out.println("Digite o nome que deseja cadastrar:");
		usuario.setNome(CapturarString(_input));
		
		System.out.println("Qual seu sexo:");
		usuario.setSexo(CapturarString(_input));
		
		do{
			System.out.println("Digite o RG:");
			String RG = _input.next();
			validacao = VerificarRG(RG, _usuarioDAO);
			usuario.setRG(RG);
		}while(!validacao);
		validacao = false;
		
		
		do{
			System.out.println("Digite o CPF:");
			String CPF = _input.next();
			validacao = VerificarCPF(CPF, _usuarioDAO);
			usuario.setCPF(CPF);
		}while(!validacao);
		validacao = false;
		
		System.out.println("Digite a Data de Nascimento(dd/MM/yyyy):");
		String data = _input.next();
		Date dataNasc = new Date();
		try {
			dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuario.setDataNascimento(dataNasc);
		
		do {
			System.out.println("Digite o email:");
			String email = _input.next();
			validacao = VerificarEmail(email, _usuarioDAO);
			usuario.setEmail(email);
		}while(!validacao);
		
		
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
	
	public static void CadastroUsuario(UsuarioDAO _usuarioDAO, Scanner _input){
		Usuario usuario = CriarUsuario(_usuarioDAO, _input);
		_usuarioDAO.saveUsuario(usuario);
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
			if(u.getNome() != null && u.getNome().contains(nomeBuscado)) {
				PrintUsuario(u);
				encontrado = true;
			}
		}
		if(encontrado == false) {
			System.out.println("Cliente não encontrado");
		}
	}
	public static void BuscarUsuarioID(UsuarioDAO _usuarioDAO, Scanner _input) {
		System.out.println("Digite o ID que deseja buscar:");
		int idBuscado = _input.nextInt();
		boolean encontrado = false;
		Usuario u =  _usuarioDAO.getUsuarioID(idBuscado);
		if(u.getId() != 0) {
			PrintUsuario(u);
			encontrado = true;
		}
		if(encontrado == false) {
			System.out.println("ID não encontrado");
		}
	}
	
	public static String CapturarString(Scanner inputInterno) {
		String stringEspaco = inputInterno.nextLine();
		stringEspaco = inputInterno.nextLine();
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
       
       if(!pat.matcher(_email).matches()){
    	   System.out.println("Formato de e-mail inválido");
    	   return false;
       }
       
       if(_usuarioDAO.getUsuarioEmail(_email)) {
    	   System.out.println("O e-mail já está cadastrado");
    	   return false;
       }
           
       return true;
	}
	
	public static Boolean VerificarCPF(String _CPF, UsuarioDAO _usuarioDAO) {
       if (_CPF == null) {
    	   System.out.println("O CPF não pode ser nulo");
    	   return false;
       }
       
       if(_usuarioDAO.getUsuarioCPF(_CPF)) {
    	   System.out.println("O CPF já está cjadastrado");
    	   return false;
       }
           
       return true;
	}
	
	public static Boolean VerificarRG(String _RG, UsuarioDAO _usuarioDAO) {
       if (_RG == null) {
    	   System.out.println("O RG não pode ser nulo");
    	   return false;
       }
       
       if(_usuarioDAO.getUsuarioRG(_RG)) {
    	   System.out.println("O RG já está cadastrado");
    	   return false;
       }
           
       return true;
	}
	
	public static void Login(UsuarioDAO _usuarioDAO, Scanner _input, boolean _logado, boolean _master) {
	   System.out.println("Digite o e-mail cadastrado");
	   String email = _input.next();
	       
	   System.out.println("Digite a senha.");
	   String senha = _input.next();
	   
	   if(_usuarioDAO.Login(email, senha)) {
		   _logado = true;
		   System.out.println("Usuario autenticado, login realizado");
	   } else {
		   _logado = false;
		   System.out.println("e-mail ou senha incorretos");
	   }
	   
	}
}