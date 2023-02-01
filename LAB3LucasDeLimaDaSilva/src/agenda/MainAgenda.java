package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade e @author Lucas de Lima da Silva.
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
			"(C)adastrar Contato\n" + 
			"(L)istar Contatos\n" + 
			"(E)xibir Contato\n" + 
			"(F)avoritos\n" +
			"(A)dicionar Favorito\n" +
			"(T)ags\n" +
			"(R)Remover Contato\n" +
			"(S)air\n" +
			"\n" + 
			"Opção> ");
		return scanner.nextLine().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "T":
			adicionaTags(agenda, scanner);
			break;
		case "R":
			removeContato(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!\n");
		}
	}

	private static void removeContato(Agenda agenda, Scanner scanner) {
		System.out.print("Contato(s)> ");
		String[] contatosAExcluir = scanner.nextLine().split(" ");
		System.out.println(" ");
		if(agenda.verificaNull(contatosAExcluir)) {
			System.out.println("POSIÇÃO INVÁLIDA!\n");
			return;
		}
		agenda.removeContato(contatosAExcluir);
	}

	private static void adicionaTags(Agenda agenda, Scanner scanner) {
		System.out.print("Contato(s)> ");
		String contatos = scanner.nextLine();
		System.out.print("Tag> ");
		String tag = scanner.nextLine();
		System.out.print("Posicao tag> ");
		int posicaoTag = Integer.parseInt(scanner.nextLine());
		System.out.println(" ");
		agenda.adicionaTags(contatos, tag, posicaoTag);
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println(agenda.listaContatos());
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		Contato contatoAExibir = agenda.getContato(posicao);
		if(contatoAExibir != null) {
			if(agenda.verificaFavorito(posicao)) {
				System.out.println("❤️ " + contatoAExibir);
				System.out.println(agenda.getContato(posicao).getTags());
				return;
			}
			System.out.println(contatoAExibir);
			System.out.println(agenda.getContato(posicao).getTags());
			return;
		}
		System.out.println("POSIÇÃO INVÁLIDA!\n");
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		if(posicao < 1 || posicao > 100) {
			System.out.println("POSIÇÃO INVÁLIDA\n");
			return;
		}
		System.out.print("Nome> ");
		String nome = scanner.nextLine();
		if(nome.isEmpty()) {
			System.out.println("CONTATO INVALIDO\n");
			return;
		}
		System.out.print("Sobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("Telefone> ");
		String telefone = scanner.nextLine();
		if(telefone.isEmpty()) {
			System.out.println("CONTATO INVALIDO\n");
			return;
		}
		if(agenda.verificaContato(nome, sobrenome, telefone)) {
			System.out.println("CONTATO JA CADASTRADO\n");
			return;
		}
		agenda.cadastraContato(posicao, nome, sobrenome, telefone);
		System.out.println("CADASTRO REALIZADO\n");
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}

	private static void listaFavoritos(Agenda agenda) {
		System.out.println(agenda.listaFavoritos());
	}

	private static void adicionaFavorito(Agenda agenda,Scanner scanner) {
		System.out.print("Contato> ");
		int contatoPosicao = Integer.parseInt(scanner.nextLine());
		System.out.print("Posicao> ");
		int posicaoFavoritos = Integer.parseInt(scanner.nextLine());
		if(agenda.verificaFavorito(contatoPosicao)) {
			System.out.println("CONTATO JA FAVORITADO\n");
			return;
		}
		agenda.adicionaFavorito(contatoPosicao, posicaoFavoritos);
		System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicaoFavoritos + "!\n");
	}
}
