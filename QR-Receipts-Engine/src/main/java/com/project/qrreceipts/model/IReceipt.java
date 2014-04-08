package com.project.qrreceipts.model;

import java.util.List;

public interface IReceipt {

	public abstract String getTitle();

	public abstract void setTitle(String title);

	public abstract List<IReceiptItem> getItems();

	public abstract void setItems(List<IReceiptItem> items);

	public abstract double getTax();

	public abstract void setTax(double tax);

	public abstract double getTotal();

}