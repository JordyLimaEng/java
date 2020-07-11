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
		
		//a variável x representa o número do episódio
		for (int x = 1; x <= 22; x++) {

			if(x>=1 && x<=9) {//para episodios até o numero 9
				File NomeAntigo = new File("C:\\Users\\Jordy\\DownloadsTorrents\\TMOC T4\\Todo.Mundo.Odeia.o.Chris.T04E0"+x+".WEB-DL.720p.Dublado.WWW.TORRRENTDOSFILMES.COM.mkv");
				File NomeAtual = new File("C:\\Users\\Jordy\\DownloadsTorrents\\TMOC T4\\T04E0"+x+".mkv");
				Scanner sc = null;

				try {
					if (NomeAntigo.renameTo(NomeAtual)) {
						System.out.println(NomeAntigo.getName() + " -> " + NomeAtual.getName());
					} else {
						System.out.println("Não foi possivel renomear");
					}
				} finally {// independente do resultado executa o finally
					if (sc != null) {
						sc.close();
					}
				}
			}else{//para episodios maiores que 9
				File NomeAntigo = new File("C:\\Users\\Jordy\\DownloadsTorrents\\TMOC T4\\Todo.Mundo.Odeia.o.Chris.T04E"+x+".WEB-DL.720p.Dublado.WWW.TORRRENTDOSFILMES.COM.mkv");
				File NomeAtual = new File("C:\\Users\\Jordy\\DownloadsTorrents\\TMOC T4\\T04E"+x+".mkv");
				Scanner sc = null;

				try {
					if (NomeAntigo.renameTo(NomeAtual)) {
						System.out.println(NomeAntigo.getName() + " -> " + NomeAtual.getName());
					} else {
						System.out.println("Não foi possivel renomear");
					}
				} finally {// independente do resultado executa o finally
					if (sc != null) {
						sc.close();
					}
				}
			}

		}
		
	}