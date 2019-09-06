package com.library.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.dao.LibraryDao;
import com.library.model.Library;
import com.library.validate.Validation;


@Service
public class LibraryService {
	@Autowired
	Validation validation;

	@Autowired
	LibraryDao librarydao;

	private static final Logger logger = LogManager.getLogger(LibraryService.class);

	public Library create(Library library) throws Exception {
		Library result = null;

		try {
			validation.validate(library);
			result = librarydao.create(library);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	
	

	public List<Library> getall(Integer pageNo, Integer pageSize, String sortBy) {
		logger.info("logger from service pagination");
		return librarydao.getall(pageNo, pageSize, sortBy);
	}
	

	public List<Library> getAll() {
		logger.info("hey logger from getall service");
		return librarydao.getAll();
	}
	
	
	public Library delete(Library library) {
		logger.info("Info log");
		librarydao.delete(library);
		return library;
	}

	public Library update(Library library) {
		logger.info("Logger from service update");
		return librarydao.update(library);
	}
}