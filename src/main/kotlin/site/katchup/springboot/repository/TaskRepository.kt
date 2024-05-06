package site.katchup.springboot.repository

import org.springframework.data.jpa.repository.JpaRepository
import site.katchup.springboot.entity.Task

interface TaskRepository : JpaRepository<Task, Long>
