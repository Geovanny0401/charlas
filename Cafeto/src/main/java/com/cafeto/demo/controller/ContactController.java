package com.cafeto.demo.controller;

import com.cafeto.demo.exception.ModelNotFoundException;
import com.cafeto.demo.model.Contact;
import com.cafeto.demo.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/save")
    public ResponseEntity create(@Valid @RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.save(contact));
    }

    @GetMapping("/listAll")
    public Iterable<Contact> listAllPersons() {
        return contactService.list();
    }

    @GetMapping("/list/{id}")
    public Contact listPersonById(@PathVariable("id") long id) {
        Optional<Contact> person = contactService.listId(id);
        if(person.isPresent()) {
            return person.get();
        }
        throw new ModelNotFoundException("Invalid find person provided");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id, @Valid @RequestBody Contact contact) {
        if (!contactService.listId(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(contactService.save(contact));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!contactService.listId(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        contactService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
