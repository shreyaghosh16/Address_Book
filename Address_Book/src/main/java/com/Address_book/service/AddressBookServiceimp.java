package com.Address_book.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Address_book.model.AddressBook;
import com.Address_book.repository.AddressBookRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class AddressBookServiceimp implements AddressBookService {

	@Autowired
	private AddressBookRepository addressBookRepository;
	

	@Override
	public List<AddressBook> getAllAddressBook()
	{
		return addressBookRepository.findAll() ;
	}
	
	@Override
    public void saveAddressBook(AddressBook addressBook) {
        this.addressBookRepository.save(addressBook);
    }
	
	@Override
	public
	AddressBook getAddressById(int id) {
	    java.util.Optional<AddressBook> optional = addressBookRepository.findById(id);
	    AddressBook addressBook = null;
	    if (optional.isPresent()) {
	        addressBook = optional.get();
	    } else {
	        throw new RuntimeException(" Address not found for id :: " + id);
	    }
	    return addressBook;
	}
	
	@Override
	 public void deleteAddressById(int id) {
	  this.addressBookRepository.deleteById(id);
	 }
}