package com.iciot.controller;

import com.iciot.domain.Student;
import com.iciot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 学生信息相关的控制器类，处理与学生信息有关的HTTP请求
@RestController
@RequestMapping("/students")
public class StudentController {
    // 自动注入StudentService，用于调用业务逻辑方法
    @Autowired
    private StudentService studentService;

    // 处理添加学生信息的POST请求，接收JSON格式的学生信息并插入数据库
    @PostMapping
    public String insert(@RequestBody Student student) {
        try {
            studentService.insert(student);
            return "学生信息添加成功";
        } catch (Exception e) {
            return "学生信息添加失败: " + e.getMessage();
        }
    }

    // 处理删除学生信息的DELETE请求，根据学号删除学生信息
    @DeleteMapping("/{stuNO}")
    public String delete(@PathVariable int stuNO) {
        try {
            studentService.delete(stuNO);
            return "学生信息删除成功";
        } catch (Exception e) {
            return "学生信息删除失败: " + e.getMessage();
        }
    }

    // 处理更新学生信息的PUT请求，接收JSON格式的学生信息并更新数据库
    @PutMapping
    public String update(@RequestBody Student student) {
        try {
            studentService.update(student);
            return "学生信息更新成功";
        } catch (Exception e) {
            return "学生信息更新失败: " + e.getMessage();
        }
    }

    // 处理查询所有学生信息的GET请求，返回所有学生信息列表
    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    // 处理根据学号查询学生信息的GET请求，返回指定学号的学生信息
    @GetMapping("/{stuNO}")
    public Student findByStuNO(@PathVariable int stuNO) {
        return studentService.findByStuNO(stuNO);
    }
    // 学生信息模糊查询
    @GetMapping("/search")
    public List<Student> fuzzySearchByName(@RequestParam("keyword") String keyword) {
        return studentService.fuzzySearchByName(keyword);
    }
}