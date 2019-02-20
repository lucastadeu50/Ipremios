package com.example.ipremios.model.ListItem;

public class ItensItem{
	private String image;
	private String image_medium;
	private String description;
	private String title;
	private String uuid;
	private String image_thumb;

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
}
