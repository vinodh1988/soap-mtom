package com.rest.service.soap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWs {

	@Override
	public void upload(DataHandler attachment,String filename) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			 inputStream = attachment.getInputStream();
			
			 outputStream = new FileOutputStream(
					new File("D:\\"+filename));
			byte[] b = new byte[1000000];
			int bytesRead = 0;

			while ((bytesRead = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, bytesRead);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public DataHandler download(String filename) {
		return new DataHandler(new FileDataSource(new File("d:\\"+filename)));
	}

}
