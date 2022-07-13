package br.com.fellipe.tinnova.entities.enums;



public enum Fornecedor {

	FIAT("FIAT"),FORD("FORD"),VOLKSWAGEN("VOLKSWAGEN"),CHEVROLET("CHEVROLET");
	
	private String nome;

	private Fornecedor(String nome) {
		this.nome = nome;
	}



	
	public  String getNome() {
		return nome;
	}




	public static Fornecedor valueof(String status){
		for(Fornecedor fornecedor: Fornecedor.values()) {
			if(fornecedor.getNome() == status) {
				return fornecedor;
			}
		}
		throw new IllegalArgumentException("Veículo inválido");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNome();
	}
}
