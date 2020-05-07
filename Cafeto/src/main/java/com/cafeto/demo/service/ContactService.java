package com.cafeto.demo.service;

import com.cafeto.demo.model.Contact;
import com.cafeto.demo.repository.IContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private IContactRepository dao;

    public Contact save(Contact t) { return dao.save(t); }

    public void deleteById(long id) { dao.deleteById(id); }

    public Iterable<Contact> list() { return dao.findAll(); }

    public Optional<Contact> listId(long id) {
        return dao.findById(id);
    }
}
