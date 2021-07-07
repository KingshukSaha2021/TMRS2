package com.persistent.datapractice.tmrs.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.persistent.datapractice.tmrs.model.TaskComment;
import com.persistent.datapractice.tmrs.repositories.CommentRepository;
import com.persistent.datapractice.tmrs.repositories.CommentServiceRepository;


@Path("/comment")
public class CommentkService {
	
	CommentRepository commentRepository;
	CommentServiceRepository commentServiceRepository;
	
	@Autowired
	public CommentkService(CommentRepository commentRepository, CommentServiceRepository commentServiceRepository) {
		this.commentRepository = commentRepository;
		this.commentServiceRepository = commentServiceRepository;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addComment(TaskComment comment) {
		commentRepository.save(comment);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{taskId}")
	public List<TaskComment> getAllComments(long taskId){
		List<TaskComment> allComments = new ArrayList<TaskComment>();
		
		allComments = commentServiceRepository.getAllComments(taskId);
		
		return allComments;
	}

}
