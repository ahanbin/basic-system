package cn.com.hanbinit.system.repository;

import cn.com.hanbinit.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
