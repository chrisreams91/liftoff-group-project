package org.launchcode.liftoffgroupproject.data;

import org.launchcode.liftoffgroupproject.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{

    User findByUsername(String username);

}
