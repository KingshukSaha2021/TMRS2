package com.persistent.datapractice.tmrs.service;

import com.persistent.datapractice.tmrs.model.AllTaskModel;
import com.persistent.datapractice.tmrs.model.Users;
import com.persistent.datapractice.tmrs.repositories.UserServiceRespository;
import com.persistent.datapractice.tmrs.repositories.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;


@Path("/user")
public class UsersService {

	private UsersRepository repository;
	private UserServiceRespository serviceRepository;

	@Autowired
	public UsersService(UsersRepository repository, UserServiceRespository serviceRepository) {
		this.repository = repository;
		this.serviceRepository = serviceRepository;
	}

	public List<Users> findAll() {
		return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String validateUser(Users user) {
	
		System.out.println("Inside UsersService: validateUser");
		
		serviceRepository.validateUser(user);
		
		return "login successful";
	}
	 
	@GET
	@Path("/getTasks/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AllTaskModel> getAllTasksForEmployee(@PathParam("userId") long userId){ 
		return serviceRepository.getAllTasksForEmployee(userId); 
	}
	
	
	@GET
	@Path("/getAll/{managerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> findAllUsers(@PathParam("managerId")long managerId){ return
			serviceRepository.findAllUsers(managerId); 
	}
	
 
}
