package com.persistent.datapractice.tmrs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistent.datapractice.tmrs.model.TaskComment;

@Repository
public interface CommentRepository extends JpaRepository<TaskComment, Long>{
	
	

}
