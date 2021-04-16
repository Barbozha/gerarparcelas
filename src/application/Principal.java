package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Installment;
import model.services.ContractService;
//import model.services.OnlinePaymentService;
import model.services.PaypalService;

public class Principal {

	public static void main(String[] args) throws ParseException {
		// Uma empresa deseja automatizar o processamento de seus contratos. 
		// O processamento de um contrato consiste em gerar as parcelas a 
		// serem pagas para aquele contrato, com base no número de meses desejado.
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int numero = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double valor = sc.nextDouble();
		Contrato contrato = new Contrato(numero, data, valor);
		
		System.out.print("Enter number of installments: ");
		int numParcela = sc.nextInt();
		
		// chamo o meu serviço 
		// O program principal Injetará a dependência da instância que será usada.
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contrato, numParcela);
		
		//Impressão
		System.out.println("Installments:");
		for(Installment prestacao : contrato.getParcelas()) {
			System.out.println(prestacao);
		}
		sc.close();
	}

}
