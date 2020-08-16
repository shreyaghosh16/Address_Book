package com.Address_book.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Address_book.model.AddressBook;
import com.Address_book.repository.AddressBookRepository;
import com.Address_book.service.AddressBookService;



@Controller
public class AddressBookController {

	@Autowired
	private AddressBookRepository addressBookRepository;
	
	@Autowired
    private AddressBookService addressBookService;

	



	 @GetMapping(value = "/all")
	    public List<AddressBook> getAll1() {
	        return addressBookRepository.findAll();
	    }

	
	@GetMapping("/admin/all")
	public String securedHello() {
		return "Secured Hello";
	}
	
	 @GetMapping("/")
	    public String viewHomePage(Model model) {
	        model.addAttribute("listUsers", addressBookService.getAllAddressBook());
	        return "index";
	    }
	 
	 @GetMapping("/showNewAddressBook")
	 public String showNewAddressBook(Model model) {
	     AddressBook addressBook = new AddressBook();
	     model.addAttribute("listUsers", addressBook);
	     return "new_addressBook";
	 }
	 
	 @PostMapping("/saveAddress")
	 public String saveAddressBook(@ModelAttribute("listUsers") AddressBook addressBook) {
		 addressBookService.saveAddressBook(addressBook);
	     return "redirect:/";
	 }
	 
	 @GetMapping("/showFormForUpdate/{id}")
	 public String showFormForUpdate(@PathVariable ( value = "id") Integer id, Model model) {
	  
	  // get employee from the service
	  AddressBook addressBook = addressBookService.getAddressById(id);
	  
	  // set employee as a model attribute to pre-populate the form
	  model.addAttribute("listUsers", addressBook);
	  return "update_addressBook";
	 }
	 
	 @GetMapping("/deleteAddress/{id}")
	 public String deleteAddress(@PathVariable (value = "id") int id) {
	  
	  // call delete employee method 
	  this.addressBookService.deleteAddressById(id);
	  return "redirect:/";
	 }
}