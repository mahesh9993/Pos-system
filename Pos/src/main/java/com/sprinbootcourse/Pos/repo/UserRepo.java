package com.sprinbootcourse.Pos.repo;

import com.sprinbootcourse.Pos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    boolean existsByUserNameAndPassword (String userName, String password);

}
