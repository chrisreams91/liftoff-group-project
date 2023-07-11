package org.launchcode.liftoffgroupproject.data;

import org.launchcode.liftoffgroupproject.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
