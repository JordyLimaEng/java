package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Renomeador {

	public static void main(String[] args) {

		// pega todos os arquivos de um diretório e renomeia para um nome ou sequência
		// requerida

		File dir = new File("C:\\Users\\Jordy\\Documents\\React-Native\\catalogo\\src\\images");// arquivos de origem

		int indice = 0;

		if (dir.isDirectory()) { // verifica se é diretório
			for (final File f : dir.listFiles()) {
				try {
					indice++;
					File newfile = new File(
							"C:\\Users\\Jordy\\Documents\\React-Native\\catalogo\\src\\images\\" + indice + ".jpg");// local e arquivos onde vai salvar

					if (f.renameTo(newfile)) {
						System.out.println("Arquivo renomeado");
					} else {
						System.out.println("Não foi possível renomear");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
