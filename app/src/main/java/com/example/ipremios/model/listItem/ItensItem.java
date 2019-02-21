package com.example.ipremios.model.listItem;

import android.os.Parcel;
import android.os.Parcelable;

public class ItensItem implements Parcelable {
	private String image;
	private String image_medium;
	private String description;
	private String title;
	private String uuid;
	private String image_thumb;

	protected ItensItem(Parcel in) {
		image = in.readString();
		image_medium = in.readString();
		description = in.readString();
		title = in.readString();
		uuid = in.readString();
		image_thumb = in.readString();
	}

	public static final Creator<ItensItem> CREATOR = new Creator<ItensItem>() {
		@Override
		public ItensItem createFromParcel(Parcel in) {
			return new ItensItem(in);
		}

		@Override
		public ItensItem[] newArray(int size) {
			return new ItensItem[size];
		}
	};

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setImageMedium(String imageMedium){
		this.image_medium = imageMedium;
	}

	public String getImageMedium(){
		return image_medium;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUuid(String uuid){
		this.uuid = uuid;
	}

	public String getUuid(){
		return uuid;
	}

	public void setImageThumb(String imageThumb){
		this.image_thumb = imageThumb;
	}

	public String getImageThumb(){
		return image_thumb;
	}

	@Override
 	public String toString(){
		return 
			"ItensItem{" + 
			"image = '" + image + '\'' + 
			",image_medium = '" + image_medium + '\'' +
			",description = '" + description + '\'' + 
			",title = '" + title + '\'' + 
			",uuid = '" + uuid + '\'' + 
			",image_thumb = '" + image_thumb + '\'' +
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(image);
		dest.writeString(image_medium);
		dest.writeString(description);
		dest.writeString(title);
		dest.writeString(uuid);
		dest.writeString(image_thumb);
	}
}
