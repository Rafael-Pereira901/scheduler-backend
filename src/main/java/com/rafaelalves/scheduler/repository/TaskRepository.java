package com.rafaelalves.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelalves.scheduler.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {}
