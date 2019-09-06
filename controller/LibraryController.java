package com.library.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Library;
import com.library.service.LibraryService;

@RestController
@RequestMapping("library")
public class LibraryController {
	private static final Logger logger = LogManager.getLogger(LibraryController.class);
	@Autowired
	LibraryService libraryservice;

	@PostMapping
	public Library create(@RequestBody Library library) throws Exception {
		Library result = null;
		try {
			result = libraryservice.create(library);
		} catch (Exception e) {
			logger.error("error occured in controler create ");
			throw e;
		}
		return result;
	}



	@GetMapping
	public List<Library> getall(@RequestParam(defaultValue = "3") Integer pageNo,
			@RequestParam(defaultValue = "0") Integer pageSize, @RequestParam(defaultValue = "name") String sortBy) {
		return libraryservice.getall(pageNo, pageSize, sortBy);
	}
	
	@GetMapping("All")
	public List<Library> getAll() {
		return libraryservice.getAll();
	}

	@DeleteMapping("{id}")
	public Library delete(@PathVariable Long id, Library library) {
		logger.info("Hey there initializing delete operation");
		return libraryservice.delete(library);
	}

	@PutMapping("{id}")
	public Library update(@PathVariable Long id, Library library) {
		libraryservice.update(library);
		return libraryservice.update(library);
	}
}