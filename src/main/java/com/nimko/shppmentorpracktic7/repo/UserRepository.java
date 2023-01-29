package com.nimko.shppmentorpracktic7.repo;

import com.nimko.shppmentorpracktic7.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
