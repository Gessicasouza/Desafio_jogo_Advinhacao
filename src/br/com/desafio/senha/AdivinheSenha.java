package br.com.desafio.senha;

import java.util.Random;
import java.util.Scanner;

public class AdivinheSenha {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Random random = new Random();
		String numSorteado = (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + ""
				+ (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10);

		String resultado = "";

		int quantidadeTentativas = 0;
		do {
			resultado = "";
			System.out.println("Digite 5 numeros para adivinhar a senha: ");
			String numUsuario = sc.nextLine();
			if (numUsuario.length() == 5) {
				if (numUsuario == numSorteado) {
					resultado = "OOOOO";
				} else {
					for (int i = 0; i < 5; i++) {

						if (numUsuario.charAt(i) == numSorteado.charAt(i)) {
							resultado += "O";
						} else if (numSorteado.contains(numUsuario.charAt(i) + "")) {
							resultado += "-";
						} else
							resultado += "X";
					}
				}
			} else {
				System.out.println("Opção Inválida");
			}
			System.out.println(resultado);
		} while (!resultado.equals("OOOOO") && quantidadeTentativas++ < 15);

		if (resultado.equals("OOOOO")) {
			System.out.println("Você  ganhou, Parabéns");
		} else {
			System.out.println("Vc perdeu, tente novamente!");
		}
		System.out.println("Numero sorteado " + numSorteado);
		sc.close();
	}
}