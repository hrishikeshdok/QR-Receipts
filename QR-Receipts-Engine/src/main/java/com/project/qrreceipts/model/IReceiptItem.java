package com.project.qrreceipts.model;

public interface IReceiptItem {

	public abstract String getItemDescription();

	public abstract void setItemDescription(String itemDescription);

	public abstract double getQuantity();

	public abstract void setQuantity(double quantity);

	public abstract double getUnitPrice();

	public abstract void setUnitPrice(double unitPrice);

	public abstract double getItemTotal();

}