package questao2;

import java.util.Locale;

public class ProdutoImportado extends Produto{

	private double taxa;

	public ProdutoImportado(String nome, double preco, double taxa) {
		super(nome, preco);
		this.taxa = taxa;
	}
	
	public double precoTotal() {
		return preco + taxa;
		
	}
	
	@Override 
	public String etiqueta() {
		return String.format(Locale.US, "%s R$ %.2f (Taxa Alfândega: R$ %.2F", nome, precoTotal(), taxa).replace(".", ",");
	}
	
}

