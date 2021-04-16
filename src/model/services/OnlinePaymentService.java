package model.services;

public interface OnlinePaymentService {
	double taxaPagamento(double valor);
	double juros(double valor, int meses);
}
