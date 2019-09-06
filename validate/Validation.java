package com.library.validate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.library.dao.LibraryDao;
import com.library.model.Library;

@Component
public class Validation {

	private static final Logger logger = LogManager.getLogger(LibraryDao.class);

	public void validate(Library library) throws Exception {
		try {
			if (library.getNumber() == (int) library.getNumber()) {
				if (library.getName() != null && library.getName().matches("^[a-zA-Z]*$")) {
					if (library.getPrice() == (float) library.getPrice()) {

					} else {
						throw new NumberFormatException("Enter only number");
					}

				} else {
					throw new Exception("Enter only alphabets");
				}
			} else {
				throw new NumberFormatException("Enter only numeric");

			}

		} catch (Exception e) {
			logger.error("exception occured in all validation");
			throw e;
		}
	}

}