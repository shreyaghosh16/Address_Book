package com.Address_book.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Address_book.model.AddressBook;


@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer>
{

	
	

}