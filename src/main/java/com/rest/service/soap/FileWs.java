package com.rest.service.soap;
import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public interface FileWs {

	void upload(@WebParam(name = "file") DataHandler attachment,@WebParam(name="filename")String filename);

	DataHandler download(@WebParam(name="filename")String fileaname);

}