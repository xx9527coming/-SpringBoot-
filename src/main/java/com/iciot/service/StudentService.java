package com.iciot.service;

import com.iciot.domain.Student;

import java.util.List;

// 学生服务接口，定义了与学生信息相关的业务操作方法
public interface StudentService {
    // 插入学生信息
    void insert(Student student);
    // 根据学号删除学生信息
    void delete(int stuNO);
    // 更新学生信息
    void update(Student student);
    // 查询所有学生信息
    List<Student> findAll();
    // 根据学号查询单个学生信息
    Student findByStuNO(int stuNO);
    //模糊查询
    List<Student> fuzzySearchByName(String keyword);
}