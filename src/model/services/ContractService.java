package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	//Pelo construtor eu injeto a dependência onlinePaymentService
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contrato contrato, int meses) {
		double quotaBasica = contrato.getValorTotal() / meses;
		for(int i= 1 ; i <= meses ; i++) {
			   double quotaIntermediaria = quotaBasica + onlinePaymentService.juros(quotaBasica, i);
			   double quota = quotaIntermediaria + onlinePaymentService.taxaPagamento(quotaIntermediaria);
			   Date dataVencimento = adicionarMeses(contrato.getData(), i);
			   
			   // Acesso a lista de parcelas do meu contrato, adiciono um novo objeto
			   contrato.getParcelas().add(new Installment(dataVencimento,quota));
		}
	}
	
	private Date adicionarMeses(Date data, int N) {
		Calendar call = Calendar.getInstance();
		call.setTime(data);
		//adiciono N (quantidade de meses) ao calendário.
		call.add(Calendar.MONTH, N);
		//retorna o date
		return call.getTime();
	}
}
