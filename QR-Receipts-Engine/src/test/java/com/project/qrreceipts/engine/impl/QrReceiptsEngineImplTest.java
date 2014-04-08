package com.project.qrreceipts.engine.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.project.qrreceipts.engine.IQrReceiptsEngine;
import com.project.qrreceipts.model.IReceipt;
import com.project.qrreceipts.model.IReceiptItem;
import com.project.qrreceipts.model.Receipt;
import com.project.qrreceipts.model.ReceiptItem;

public class QrReceiptsEngineImplTest {

	private static Logger Log = Logger.getLogger("QrReceiptsEngineImplTest");
	private IReceipt receipt;
	static IQrReceiptsEngine qrReceiptsEngine;

	@BeforeClass
	public static void setUp() {
		qrReceiptsEngine = new QrReceiptsEngineImpl();
	}

	@Before
	public void beforeTest() {
		receipt = new Receipt();

		receipt.setTitle("Test Receipt");
		receipt.setItems(new ArrayList<IReceiptItem>() {
			{
				add(new ReceiptItem("Test Item1", 1, 0.5));
				add(new ReceiptItem("Test Item2", 1, 0.75));
				add(new ReceiptItem("Test Item3", 1, 0.25));
				add(new ReceiptItem("Test Item4", 1, 2.5));
				add(new ReceiptItem("Test Item5", 1, 2.25));
				add(new ReceiptItem("Test Item6", 1, 2.75));
				add(new ReceiptItem("Test Item7", 1, 3.5));
				add(new ReceiptItem("Test Item8", 1, 5));
			}
		});
		receipt.setTax(5.5);
	}

	@Test
	public void getAndPrintQRReceiptTest() {
		ByteArrayOutputStream stream = qrReceiptsEngine.getQRReceipt(receipt);

		try {
			FileOutputStream fout = new FileOutputStream(new File(
					"QRReceipt.JPG"));
			fout.write(stream.toByteArray());
			fout.flush();
			fout.close();
		} catch (FileNotFoundException e) {
			Log.severe("File not found " + e.getMessage());
		} catch (IOException e) {
			Log.severe(e.getMessage());
		}
	}

}
