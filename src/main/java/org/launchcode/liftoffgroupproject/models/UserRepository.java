package org.launchcode.liftoffgroupproject.models;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{

    User findByUsername(String username);

}
