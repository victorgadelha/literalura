package br.com.victorgadelha.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.victorgadelha.literalura.services.ScannerService;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	ScannerService scannerService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		scannerService.getScanner();
	}

}
