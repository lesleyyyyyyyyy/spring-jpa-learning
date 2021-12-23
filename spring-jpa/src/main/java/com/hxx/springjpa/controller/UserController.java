package com.hxx.springjpa.controller;

import com.hxx.springjpa.entity.User;
import com.hxx.springjpa.entity.UserCustomerEntity;
import com.hxx.springjpa.repository.UserCustomerRepository;
import com.hxx.springjpa.repository.UserRepository;
import com.hxx.springjpa.service.UserService;
import com.hxx.springjpa.specification.SpecificationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author xin.hao
 * @create 2020/11/4 15:52
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCustomerRepository userCustomerRepository;

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user) {
//        User save = userRepository.save(user);
//        return save;
        return userRepository.save(user);
    }

    @GetMapping("/add")
    public void addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);

    }

    @GetMapping("/all")
    @ResponseBody
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/info")
    @ResponseBody
    public User findOne(@RequestParam Integer id) {
        return userRepository.getOne(id);
    }

    @GetMapping("/delete")
    public void deleteUser(@RequestParam Integer id) {
        userRepository.deleteById(id);
    }

    /**
     * 排序、分页
     *
     * @return
     */
    @GetMapping("/page")
    @ResponseBody
    public Page<User> getAllUserByPage() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable = PageRequest.of(1, 20, sort);
        return userRepository.findAll(pageable);
    }

    @GetMapping("/sort")
    @ResponseBody
    public List<User> getAllUsersWithSort() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return userRepository.findAll(sort);

    }

    @GetMapping("/getUserWithMatcher")
    @ResponseBody
    public List<User> getuser(String name) {
        User user = new User();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withIgnorePaths("email");
        Example<User> example = Example.of(user, matcher);
        List<User> list = userRepository.findAll(example);
        for (User u : list) {
            System.out.println(u.getName());
        }
        return list;
    }

    @GetMapping("/contain")
    @ResponseBody
    public List<User> contain(String name) {
        return userRepository.findAll(SpecificationFactory.containsLike("name", name));
    }

    @GetMapping("/findById")
    @ResponseBody
    public Optional<User> findById(Integer id) {
        return userService.findById(id);
//        return userRepository.findById(id);
    }

    @GetMapping("/auditorTest")
    @ResponseBody
    public User auditorTest(String name) {
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

    @GetMapping("/auditorTest1")
    @ResponseBody
    public UserCustomerEntity auditorTest1(String name) {
        UserCustomerEntity uc = new UserCustomerEntity();
        uc.setCustomerName(name);
        return userCustomerRepository.save(uc);
    }

    @GetMapping("/versionTest")
    @ResponseBody
    public UserCustomerEntity versionTest(String name) {
        UserCustomerEntity userCustomerEntity = new UserCustomerEntity();
        userCustomerEntity.setCustomerName(name);
        userCustomerEntity.setCreateUserId(1);
        userCustomerRepository.save(userCustomerEntity);

        UserCustomerEntity uc = userCustomerRepository.findById(1).get();
        uc.setCustomerName("Jack.zhang");
        return userCustomerRepository.save(uc);
    }


}
