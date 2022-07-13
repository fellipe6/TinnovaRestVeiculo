package br.com.fellipe.tinnova.entities.enums;

public enum StatusVenda {

	VENDIDO(true),DISPONIVEL(false);
	
	private boolean status;

	private StatusVenda(boolean status) {
		this.status = status;
	}

	public boolean getStatus() {
		return status;
	}
	
	public static StatusVenda valueof(boolean status){
		for(StatusVenda venda: StatusVenda.values()) {
			if(venda.getStatus() == status) {
				return venda;
			}
		}
		throw new IllegalArgumentException("Status de venda inválida");
	}
	
}
