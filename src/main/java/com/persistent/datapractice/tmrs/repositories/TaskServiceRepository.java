package com.persistent.datapractice.tmrs.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.persistent.datapractice.tmrs.model.Tasks;

@Repository
public class TaskServiceRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void updateTask(long taskId, Tasks task) {
		String query = "Update TASKS set eta = ?, description = ?, priority = ? where id = ?";
		
		jdbcTemplate.update(query, task.getEta(), task.getDescription(), task.getPriority(), taskId);
	}
	
	public void updateCompletionPercentage(int taskId, int complementionPercentage) {
		String sql = "Update TASKS set completion = ? where id = ?";
		
		jdbcTemplate.update(sql, complementionPercentage, taskId);
	}

}
