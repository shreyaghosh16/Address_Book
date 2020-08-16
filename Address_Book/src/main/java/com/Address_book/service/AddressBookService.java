package com.Address_book.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.Address_book.model.AddressBook;

public interface AddressBookService {
	
	List<AddressBook> getAllAddressBook();
	void saveAddressBook(AddressBook addressBook);
	AddressBook getAddressById(int id);
	void deleteAddressById(int id);


}
