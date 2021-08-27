package br.com.bycoders.conversor;

import java.io.FileNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorApplication {

  public static void main(String[] args) throws FileNotFoundException {
    SpringApplication.run(ConversorApplication.class, args);
	// List<String> lines = new ArrayList<>();

    // File file = new File("/home/vinicius/WorkSpace/ByCoders/CNAB.txt");
    // Scanner scanner = new Scanner(file);	

    // while (scanner.hasNextLine()) {
	// 	lines.add(scanner.nextLine());
    // }

	// scanner.close();
    
	// lines.stream().forEach(line -> {
	// 	System.out.println("Tipo: " + line.substring(0, 1));
	// 	System.out.println("Data: " + line.substring(1, 9));
	// 	System.out.println("Valor: " + line.substring(9, 19));
	// 	System.out.println("CPF: " + line.substring(19, 30));
	// 	System.out.println("Cartão: " + line.substring(30, 42));
	// 	System.out.println("Hora: " + line.substring(42, 48));
	// 	System.out.println("Dono: " + line.substring(48, 62));
	// 	System.out.println("Loja: " + line.substring(62));
	// 	System.out.println("----------------------------------------");
	// });
	
	// System.out.println("Tipo: " + lines.get(1).substring(0, 1)); //5
	// System.out.println("Data: " + lines.get(1).substring(1, 9)); //20190301
	// System.out.println("Valor: " + lines.get(1).substring(9, 19)); //0000013200
	// System.out.println("CPF: " + lines.get(1).substring(19, 30)); //55641815063
	// System.out.println("Cartão: " + lines.get(1).substring(30, 42)); //3123****7687
	// System.out.println("Hora: " + lines.get(1).substring(42, 48)); //145607
	// System.out.println("Dono: " + lines.get(1).substring(48, 62)); //MARIA JOSEFINA
	// System.out.println("Loja: " + lines.get(1).substring(62)); //LOJA DO Ó - MATRIZ
	// System.out.println("---------------------------------------------");
  }
}
