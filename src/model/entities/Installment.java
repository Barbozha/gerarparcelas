package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	private Date dataVencimento;
	private Double valor;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Installment() {
		
	}

	public Installment(Date dataVencimento, Double valor) {
		this.dataVencimento = dataVencimento;
		this.valor = valor;
	}

	public Date getData() {
		return dataVencimento;
	}

	public void setData(Date data) {
		this.dataVencimento = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(sdf.format(dataVencimento)+" - "+String.format("%.2f", valor));
		
		return sb.toString();
	}
}
