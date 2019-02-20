package com.example.ipremios.model.ListItem;

import java.util.List;

public class Item{
	private List<ItensItem> itens;

	public void setItens(List<ItensItem> itens){
		this.itens = itens;
	}

	public List<ItensItem> getItens(){
		return itens;
	}

	@Override
 	public String toString(){
		return 
			"Item{" + 
			"itens = '" + itens + '\'' + 
			"}";
		}
}