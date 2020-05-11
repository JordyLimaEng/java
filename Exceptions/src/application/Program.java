package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Hierarquia de exceções do java
 * Throwable = error - outofmemoeryerror 
 * 			         - virtualmachineerror
 *           = exception
 *                   - IOException
 *                   - RuntimeException
 *                           -IndexOutOfBoundsException
 *                           -NullPointerException
 *                    ... algumas do JDK
 */

/*
 * Estrutura try-catch
 * 
 * try{
 * }catch(ExceptionType e){
 * 
 * }catch(ExceptionType e){
 * 
 * }
 * 

 */

public class Program {

	public static void main(String[] args) {
		metodo3();
		System.out.println("fim do programa...");
	}

	public static void metodo1() {// exemplo de stack trace
		System.out.println("\n... Metodo 1 INICIO...");
		metodo2();
		System.out.println("... Metodo 1 FIM...");
	}

	public static void metodo2() {// exemplo de try e catch
		System.out.println("\n... Metodo 2 INICIO...");
		Scanner sc = new Scanner(System.in);

		try {// quando a exceção não é tratada o programa finaliza e o stack trace é exibido
				// no console
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt(); // input exception se receber um string
			System.out.println(vect[position]); // Array Index Out of Bound Exception, se posição fora do escopo do
												// vetor, lança exceção
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Posição não existe! ");
			e.printStackTrace(); // para verificar as chamadas de funções e erros
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida! ");
		}
		System.out.println("... Metodo 2 FIM...");

		sc.close();
	}

	public static void metodo3() {// exemplo finally
		// é utilizando quando há leitura de arquivos ou conexão com banco de dados etc
		System.out.println("\n... Metodo 3 INICIO...");

		File file = new File("C:\\Users\\Jordy\\Documents\\in.txt");
		Scanner sc = null;

		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {//se encontrar o arquivo, imprime o conteúdo
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {// se arq nao encontrado executa o catch
			System.out.println("Erro ao abrir arquivo: " + e.getMessage());
		} finally {// independente do resultado executa o finally
			if (sc != null) {
				sc.close();
			}
			System.out.println("===Bloco Finally===");
		}

		System.out.println("... Metodo 3 FIM...");
	}

	
	
}
