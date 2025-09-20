package com.projectnexus.repository;

import com.projectnexus.model.Project;
import com.projectnexus.model.Task;
import com.projectnexus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject(Project project);
    List<Task> findByAssignedTo(User user);
    List<Task> findByProjectAndStatus(Project project, Task.TaskStatus status);
}