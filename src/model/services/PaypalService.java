package model.services;

public class PaypalService implements OnlinePaymentService{

	private static final double  taxaJurosPorParcela = 0.02;
	private static final double jurosMensalPaypal = 0.01;
	@Override
	public double taxaPagamento(double valor) {
		return valor * taxaJurosPorParcela;
	}

	@Override
	public double juros(double valor, int quantidadeMeses) {
		return valor * jurosMensalPaypal * quantidadeMeses;
	}

}
