package com.satya.spring.boot.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.gridfs.GridFSDBFile;


@RestController
@RequestMapping(value = "/file")
public class FileOperationController {
	
	@Autowired
	GridFsOperations gridFSOperations;
	
	@RequestMapping(value = "/uploadFile/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("id") String id){
		
		
		BasicDBObject metadata = new BasicDBObject();
		metadata.put("fileId", id);
		metadata.put("fileName", file.getOriginalFilename().replaceAll(" ", "_"));
		metadata.put("contentType", file.getContentType());
		
		try {
			//gridFSOperations.store(file.getInputStream(), metadata);
			gridFSOperations.store(file.getInputStream(), file.getOriginalFilename().replaceAll(" ", "_"), file.getContentType(), metadata);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/viewFile/{id}",method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getFile(@PathVariable("id") String id){
		
		Query query = new Query(GridFsCriteria.whereMetaData("fileId").is(id));
		
		GridFSDBFile file = gridFSOperations.findOne(query);
		InputStreamResource resource = new InputStreamResource(file.getInputStream());
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(new MediaType(file.getMetaData().get("contentType").toString()));
		headers.setContentType(MediaType.valueOf(file.getMetaData().get("contentType").toString()));
		headers.setContentDispositionFormData("attachment", file.getMetaData().get("fileName").toString());
		
		
		return new ResponseEntity<InputStreamResource>(resource, headers, HttpStatus.OK);
	}
	
	
	
	
	

}
