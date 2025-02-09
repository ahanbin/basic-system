package cn.com.hanbinit.system.controller;

import cn.com.hanbinit.system.configuration.CommonResponse;
import cn.com.hanbinit.system.entity.User;
import cn.com.hanbinit.system.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public CommonResponse<List<User>> list(){
        List<User> userList = userRepository.findAll();
        return new CommonResponse<>(userList);
    }

    @PostMapping("/add")
    public CommonResponse<User> add(@RequestBody User user){
        User savedUser = userRepository.save(user);
        return new CommonResponse<>(savedUser);
    }
}
