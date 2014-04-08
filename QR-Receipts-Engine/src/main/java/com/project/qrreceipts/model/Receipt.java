package com.project.qrreceipts.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Receipt implements IReceipt {

	private String title;
	private List<IReceiptItem> items;
	private double tax;
	private double total;

	@JsonProperty("Ti")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("I")
	public List<IReceiptItem> getItems() {
		return items;
	}

	public void setItems(List<IReceiptItem> items) {
		this.items = items;
	}

	@JsonProperty("Tx")
	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@JsonProperty("To")
	public double getTotal() {
		if (this.items == null) {
			return 0.0;
		}
		double total = 0.0;
		for (IReceiptItem iReceiptItem : items) {
			total += iReceiptItem.getItemTotal();
		}
		total = total + calculateTax(tax, total);
		return Math.round(total);
	}

	private double calculateTax(double tax, double total) {
		return total * (tax / 100);
	}
}
