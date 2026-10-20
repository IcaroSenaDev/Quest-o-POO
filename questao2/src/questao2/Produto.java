package questao2;

import java.util.Locale;

public class Produto {

	protected String nome;
	protected double preco;
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public String etiqueta() {
		
		return String.format(Locale.US, "%s R$ %.2F", nome, preco).replace(".", ",");
	
	}
	
	
	
}
