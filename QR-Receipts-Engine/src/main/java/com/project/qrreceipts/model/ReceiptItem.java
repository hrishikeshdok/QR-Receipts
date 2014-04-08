package com.project.qrreceipts.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class ReceiptItem implements IReceiptItem {

	private String itemDescription;
	private double quantity;
	private double unitPrice;
	private double itemTotal;

	public ReceiptItem(String itemDescription, double quantity, double unitPrice) {
		super();
		this.itemDescription = itemDescription;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	@JsonProperty("D")
	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@JsonProperty("Q")
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("P")
	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@JsonProperty("T")
	public double getItemTotal() {
		return this.quantity * this.unitPrice;
	}
}
