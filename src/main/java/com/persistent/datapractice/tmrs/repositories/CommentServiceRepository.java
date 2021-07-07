package com.persistent.datapractice.tmrs.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.persistent.datapractice.tmrs.mapper.TaskCommentMapper;
import com.persistent.datapractice.tmrs.model.TaskComment;

@Repository
public class CommentServiceRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<TaskComment> getAllComments(long taskId){
		
		String sql = "Select TASK_ID, COMMENT, COMMENT_TIME, USER_ID from TASK_COMMENT where task_id = ?";
		List<TaskComment> comments = new ArrayList<TaskComment>();
		
		comments = jdbcTemplate.query(sql, new Object[] {taskId}, new TaskCommentMapper());
		
		return comments;
	}

}
