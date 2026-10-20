package questao2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ProdutoUsado extends Produto{

		private LocalDate dataFabricacao;

		public ProdutoUsado(String nome, double preco, LocalDate dataFabricacao) {
			super(nome, preco);
			this.dataFabricacao = dataFabricacao;
		}
		
		@Override 
		public String etiqueta() {
			return String.format(Locale.US, "%s R$ %.2f (Data de Fabricação: %s", nome, preco, dataFabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).replace(".", ","));
		}
		
		
}
