package com.in28minutes.springmvc.services.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.in28minutes.springmvc.services.web.model.AddressBook;
import com.in28minutes.springmvc.services.web.service.api.AddressBookService;

@Service
public class AddressBookServiceImpl implements AddressBookService {

	List<AddressBook> addressBooks = new ArrayList<AddressBook>();
	private static Long id = 0L;

	@PostConstruct
	public void setupAddressBook() {
		AddressBook addressBook1 = new AddressBook();
		addressBook1.setEmail("test@mail.com");
		addressBook1.setFirstName("John");
		addressBook1.setLastName("Doe");
		addressBook1.setPhone("12345678");
		AddressBook addressBook2 = new AddressBook();
		addressBook2.setFirstName("George");
		addressBook2.setLastName("Lucas");
		addressBook2.setPhone("0099332244");
		addressBook2.setEmail("george.lucas@mail.com");
		addressBooks.add(addressBook1);
		addressBooks.add(addressBook2);
	}

	public List<AddressBook> viewAllAddressBook() {
		return addressBooks;
	}

	public void createAddressBook(AddressBook addressBook) {
		if (!addressBooks.contains(addressBook)) {
			addressBook.setId(id);
			addressBooks.add(addressBook);
			++id;
		}
	}

	public void updateAddressBook(int pos, AddressBook updateAddressBook) {
		addressBooks.set(pos, updateAddressBook);
	}

	public void deleteAddressBook(int id) {
		addressBooks.remove(id);
	}

	public void deleteAllAddressBook() {
		addressBooks.clear();
		id = 0L;
	}

	public AddressBook findAddressBook(int id) {
		return addressBooks.get(id);
	}
}
