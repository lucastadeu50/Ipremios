package com.example.ipremios.model.listItem;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Item implements Parcelable {
	private List<ItensItem> itens;

	protected Item(Parcel in) {
	}

	public static final Creator<Item> CREATOR = new Creator<Item>() {
		@Override
		public Item createFromParcel(Parcel in) {
			return new Item(in);
		}

		@Override
		public Item[] newArray(int size) {
			return new Item[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
	}
}