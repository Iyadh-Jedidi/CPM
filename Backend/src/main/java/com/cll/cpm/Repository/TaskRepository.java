package com.cll.cpm.Repository;

import com.cll.cpm.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository <Task,Long> {
}
