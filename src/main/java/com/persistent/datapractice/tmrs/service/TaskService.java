package com.persistent.datapractice.tmrs.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.persistent.datapractice.tmrs.repositories.TaskRepository;
import com.persistent.datapractice.tmrs.repositories.TaskServiceRepository;
import com.persistent.datapractice.tmrs.model.TaskAssignment;
import com.persistent.datapractice.tmrs.model.Tasks;
import com.persistent.datapractice.tmrs.repositories.TaskAssignmentRepository;
import com.persistent.datapractice.tmrs.repositories.TaskAssignmentServiceRepository;


@Path("/task")
public class TaskService {
	
	TaskRepository TaskRepository;
	TaskServiceRepository taskServiceRepository;
	TaskAssignmentRepository taskAssignmentRepository;
	TaskAssignmentServiceRepository taskAssignmentServiceRepository;
	
	
	@Autowired
	public TaskService(TaskRepository TaskRepository, TaskServiceRepository taskServiceRepository, TaskAssignmentRepository taskAssignmentRepository) {
		this.TaskRepository = TaskRepository;
		this.taskServiceRepository = taskServiceRepository;
		this.taskAssignmentRepository = taskAssignmentRepository;
	}
	

	@PUT
	@Path("/updateBlockReason/{taskId}")
	@Consumes(MediaType.TEXT_PLAIN)
	public void updateBlockReason(@PathParam("taskId") int taskId, String blockReason) {
		taskAssignmentServiceRepository.updateBlockReason(taskId, blockReason); 
	}
	 
	
	@PUT
	@Path("/updateCompletionPercentage/{taskId}")
	@Consumes(MediaType.TEXT_PLAIN)
	public void updateCompletionPercentage(@PathParam("taskId") int taskId, String completionPercentage){ 
		taskServiceRepository.updateCompletionPercentage(taskId, Integer.parseInt(completionPercentage)); 
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addTask(Tasks task) {
		TaskRepository.save(task);
	}

	@POST
	@Path("/assignTask")
	@Consumes(MediaType.APPLICATION_JSON)
	public void assignTask(TaskAssignment taskAssignment) {
		taskAssignmentRepository.save(taskAssignment);
	}
	
	@PUT
	@Path("/{taskId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_XML)
	public String updateTask(@PathParam("taskId") long taskId, Tasks task) { 
		taskServiceRepository.updateTask(taskId, task); 
		
		return "task modified";
	}
	
	@DELETE
	@Path("/{taskId}")
	public void removeTask(@PathParam("taskId") long taskId) {
		taskAssignmentRepository.deleteById(taskId);
	}
	
	public List<Tasks> getAllTasks(int id){
		List<Tasks> allTasks = new ArrayList<Tasks>();
			
		
		return allTasks;
	}
}
