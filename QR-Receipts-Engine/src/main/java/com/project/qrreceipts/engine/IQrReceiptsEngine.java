package com.project.qrreceipts.engine;

import java.io.ByteArrayOutputStream;

import com.project.qrreceipts.model.IReceipt;

/**
 * Created by piushkumar on 4/1/14.
 */
public interface IQrReceiptsEngine {
	public ByteArrayOutputStream  getQRReceipt(IReceipt receipt);
}
