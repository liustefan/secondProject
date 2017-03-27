package com.bithealth.printCore;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;


public class MyConverter{
	
	public static void convertToPng(String svgCode, String pngFilePath) {
		File file = new File(pngFilePath);
		FileOutputStream outputStream = null;
		try {
			if(!file.exists()){
				if(!file.getParentFile().exists()){
					file.getParentFile().mkdir();
				}
			};
			
			file.createNewFile();
			outputStream = new FileOutputStream(file);
			convertToPng(svgCode, outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void convertToPng(String svgCode, OutputStream outputStream){
		try {
			byte[] bytes = svgCode.getBytes("utf-8");
			PNGTranscoder t = new PNGTranscoder();
			TranscoderInput input = new TranscoderInput(
					new ByteArrayInputStream(bytes));
			TranscoderOutput output = new TranscoderOutput(outputStream);
			t.transcode(input, output);
			outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
