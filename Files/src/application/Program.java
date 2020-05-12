package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		file1("C:\\Users\\Jordy\\Documents\\in.txt"); // Abrir arquivo simples.
		System.out.println();
		file2("C:\\Users\\Jordy\\Documents\\in.txt"); // Leitura de caracteres em arquivo
		System.out.println();
		file3("C:\\Users\\Jordy\\Documents\\in.txt"); // Leitura usando streams e menos verbosa
		System.out.println();
		file4(); // Escrevendo ou sobrescrevendo arquivos
		System.out.println();
		file5("C:\\Users\\Jordy\\Documents"); // listando as pastas e arquivos de um caminho
		System.out.println();
		file6("C:\\Users\\Jordy\\Documents\\in.txt"); // Obtendo informações do caminho do arquivo
		System.out.println();
	}

	public static void file1(String path) {// forma simples de abrir

		File file = new File(path);
		Scanner sc = null;

		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {// se encontrar o arquivo, imprime o conteúdo
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {// se erro de IO
			System.out.println("Erro ao abrir arquivo: " + e.getMessage());
		} finally {// independente do resultado executa o finally
			if (sc != null) {
				sc.close();
			}
		}

	}

	public static void file2(String path) { // forma bem mais manual de manipular streams

		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr); //br é uma abstração do fr, é considerado mais flexivel e rapido
			
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();			
			}			
		}catch(IOException e){
			System.out.println("Erro: " + e.getMessage());
		}finally {
			try {// esse try é necessario pois pode dar um exception na hora de fechar o arquivo
				if(br!=null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void file3(String path) { // Manipulação de streams, menos verboso
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
						
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();			
			}			
		}catch(IOException e){
			System.out.println("Erro: " + e.getMessage());
		}				
	}
	
	public static void file4() { // Escrevendo em arquivos
		
		// Cria/Recria arquivo     new FileWriter(path)
		// Acrescenta ao arquivo existente     new FileWriter(path, true)
		
		String[] lines = new String[] {"GM","GA","GN"};
		
		String path = "C:\\Users\\Jordy\\Documents\\out.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void file5(String strPath) { // Manipulando pastas C:\Users\Jordy\Documents\Battlefield 4

		File path = new File(strPath);
		
		
		//imprimindo as pastas
		File[] folders = path.listFiles(File::isDirectory);//IsDirectory lista os caminhos das subpastas do caminho especificado.
		System.out.println("FOLDERS: ");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		// imprimindo os arquivos
		File[] files = path.listFiles(File::isFile);
		System.out.println("FILES: ");
		for (File file : files) {
			System.out.println(file);
		}
		
		//criando subpasta
		boolean success = new File(strPath + "\\new_file").mkdir();
		System.out.println("File created with success: " + success);
		System.out.println("new_file created in "+ strPath +"\\new_file");
		
		
	}

	public static void file6(String strPath) { // Manipulando pastas C:\Users\Jordy\Documents\Battlefield 4

		File path = new File(strPath);
		
		System.out.println("getName: " + path.getName());	//nome do arquivo
		System.out.println("getParent: " + path.getParent());// apenas  o caminho		
		System.out.println("getPath: " + path.getPath()); //caminho com o arquivo
		System.out.println("getFreeSpace: " + path.getFreeSpace()); //indica espaço livre na unidade
		System.out.println("getTotalSpace: " + path.getTotalSpace()); //indica espaço total da unidade
		System.out.println("LastModified: " + path.lastModified() +" ms since (00:00:00 GMT, January 1, 1970)"); //ultima vez modificado
		System.out.println("length: " + path.length() + " bytes"); //tamanho de um arquivo
		//entre outras...
		
	}
}
