package com.capgemini.basicsofrediscache.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.basicsofrediscache.entity.FileData;
import com.capgemini.basicsofrediscache.repository.FileDataJpaRepository;

@RestController
@RequestMapping("/files")
public class FileDataController {
	
	
	@Autowired
	private FileDataJpaRepository repo;
	
	@PostMapping(value="/upload",consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
	public FileData upload(@RequestParam("file") MultipartFile file) throws IOException {
		
		FileData data = new FileData();
		data.setFilename(file.getOriginalFilename());
		data.setFileType(file.getContentType());
		data.setData(file.getBytes());
		
		FileData saved = repo.save(data);
		
		return saved;
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable Integer id) {
	    // 1. Fetch the data from PostgreSQL
	    FileData fileData = repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("File not found with id: " + id));

	    // 2. Build the response with the correct headers
	    return ResponseEntity.ok()
	            .contentType(org.springframework.http.MediaType.parseMediaType(fileData.getFileType()))
	            .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, 
	                    "inline; filename=\"" + fileData.getFilename() + "\"")
	            .body(fileData.getData());
	}
}
