package com.poo.hotel.poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PooApplication {
	
	public class LimpaTerminal {
		static void limpa_windows() {
			try {
				if (System.getProperty("os.name").contains("Windows")) {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} else {
					System.out.println("Este comando só funciona no Windows.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	public static void main(String[] args) {
		SpringApplication.run(PooApplication.class, args);


		LimpaTerminal.limpa_windows();

		System.out.println("ola, mundo");
	}

}
