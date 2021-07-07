package com.persistent.datapractice.tmrs.service;

import com.persistent.datapractice.tmrs.model.UserTypes;
import com.persistent.datapractice.tmrs.repositories.UserTypesRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypesService {
	
	private UserTypesRepository repository;
	
	@Autowired
    public UserTypesService(UserTypesRepository repository) {
        this.repository = repository;
    }
	
	public List<UserTypes> findAll(){
		 return StreamSupport.stream(repository.findAll().spliterator(), false)
	                .collect(Collectors.toList());
	}
	
	

}
