package com.projectnexus.repository;

import com.projectnexus.model.Project;
import com.projectnexus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByCreatedBy(User user);
    List<Project> findByMembersContaining(User user);
}