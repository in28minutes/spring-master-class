package com.in28minutes.springmvc.services.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in28minutes.springmvc.services.web.model.AddressBook;
import com.in28minutes.springmvc.services.web.service.api.AddressBookService;

@Controller
@RequestMapping("/address")
public class AddressBookController {

	@Autowired
	AddressBookService addressBookService;

	@RequestMapping(value = "/all.json", method = RequestMethod.GET)
	public @ResponseBody List<AddressBook> viewAllAddressBook() {
		return addressBookService.viewAllAddressBook();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody void addAddressBookEntry(
			@RequestBody AddressBook addressBook) {
		addressBookService.createAddressBook(addressBook);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteAddressBookEntry(
			@PathVariable("id") String id) {
		addressBookService.deleteAddressBook(Integer.valueOf(id));
	}

	@RequestMapping(value = "/update/{pos}", method = RequestMethod.PUT)
	public @ResponseBody void updateAddressBook(
			@RequestBody AddressBook addressBook,
			@PathVariable("pos") String pos) {
		addressBookService.updateAddressBook(Integer.valueOf(pos), addressBook);
	}

	@RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
	public @ResponseBody void deleteAllAddressBook() {
		addressBookService.deleteAllAddressBook();
	}

	@RequestMapping("/layout")
	public String getTodoPartialPage() {
		return "addressbook/layout";
	}
}
