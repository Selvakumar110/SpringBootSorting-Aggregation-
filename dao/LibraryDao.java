package com.library.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.library.model.Library;
import com.library.repository.LibraryRepository;
import com.library.repository.UserRepository;

@Component
public class LibraryDao {
	private static final Logger logger = LogManager.getLogger(LibraryDao.class);

	@Autowired
	LibraryRepository repository;
	UserRepository Urepository;

	public Library create(Library library) {
		Library result = null;

		try {
			result = repository.save(library);

		} catch (Exception e) {
			throw e;

		}
		return result;

	}

	public List<Library> getall(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Library> pagedResult = repository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Library>();
		}
	}

	public List<Library> getAll() {
		logger.info("Hey I am Logger in Get ALL Section");
		return repository.findAll();
	}
	
	
	public Library delete(Library library) {
		repository.delete(library);
		return library;
	}

	public Library update(Library library) {
		return repository.save(library);
	}

}