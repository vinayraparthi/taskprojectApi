package com.teluguskillhub.taskproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teluguskillhub.taskproject.entity.Task;

public interface TaskRepo  extends JpaRepository<Task, Long>{

	List<Task> findAllByUsersId(long userid);

}
