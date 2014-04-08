package com.project.qrreceipts.engine.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.project.qrreceipts.engine.IQrReceiptsEngine;
import com.project.qrreceipts.model.IReceipt;

public class QrReceiptsEngineImpl implements IQrReceiptsEngine {

	private static Logger Log = Logger.getLogger("QrReceiptsEngineImpl");

	public ByteArrayOutputStream getQRReceipt(IReceipt receipt) {
		String jsonReceipt;

		Gson gson = new Gson();
		jsonReceipt = gson.toJson(receipt);

		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonReceipt = mapper.writeValueAsString(receipt);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Log.info(jsonReceipt);

		ByteArrayOutputStream qrStream = QRCode.from(jsonReceipt)
				.to(ImageType.JPG).stream();

		return qrStream;
	}

}
