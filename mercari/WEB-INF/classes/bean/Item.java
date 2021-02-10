package bean;

import java.io.Serializable;

public class Item implements Serializable{
	private String itemId;
	private String itemName;
	private int price;
	private String itemImage;
	private String itemExplanation;
	private String hardwareId;
	private String categoryId;
	private String sellerId;
	private int term;
	private int stock;
	private String listingDate;

	public Item() {}

	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public String getItemExplanation() {
		return itemExplanation;
	}
	public void setItemExplanation(String itemExplanation) {
		this.itemExplanation = itemExplanation;
	}
	public String getHardwareId() {
		return hardwareId;
	}
	public void setHardwareId(String hardwareId) {
		this.hardwareId = hardwareId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getListingDate() {
		return listingDate;
	}
	public void setListingDate(String listingDate) {
		this.listingDate = listingDate;
	}
}
