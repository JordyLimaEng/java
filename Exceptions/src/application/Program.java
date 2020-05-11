package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Hierarquia de exce��es do java
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

		try {// quando a exce��o n�o � tratada o programa finaliza e o stack trace � exibido
				// no console
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt(); // input exception se receber um string
			System.out.println(vect[position]); // Array Index Out of Bound Exception, se posi��o fora do escopo do
												// vetor, lan�a exce��o
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Posi��o n�o existe! ");
			e.printStackTrace(); // para verificar as chamadas de fun��es e erros
		} catch (InputMismatchException e) {
			System.out.println("Entrada inv�lida! ");
		}
		System.out.println("... Metodo 2 FIM...");

		sc.close();
	}

	public static void metodo3() {// exemplo finally
		// � utilizando quando h� leitura de arquivos ou conex�o com banco de dados etc
		System.out.println("\n... Metodo 3 INICIO...");

		File file = new File("C:\\Users\\Jordy\\Documents\\in.txt");
		Scanner sc = null;

		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {//se encontrar o arquivo, imprime o conte�do
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
