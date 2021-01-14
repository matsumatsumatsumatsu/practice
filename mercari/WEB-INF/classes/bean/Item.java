package bean;

import java.io.Serializable;

public class Item implements Serializable{
	private int itemId;
	private String itemName;
	private int price;
	private String itemImage;
	private String itemExplanation;
	private int hardwareId;
	private int categoryId;
	private int sellerId;
	private int term;
	private int stock;
	private int listingDate;

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
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
	public int getHardwareId() {
		return hardwareId;
	}
	public void setHardwareId(int hardwareId) {
		this.hardwareId = hardwareId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
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
	public int getListingDate() {
		return listingDate;
	}
	public void setListingDate(int listingDate) {
		this.listingDate = listingDate;
	}
}
