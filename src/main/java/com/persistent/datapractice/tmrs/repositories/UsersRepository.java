package com.persistent.datapractice.tmrs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.persistent.datapractice.tmrs.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	/*
	 * @Query("select u from USERS u where u.manager_id = ?1") List<Users>
	 * findByManagerId(int id);
	 */
}
