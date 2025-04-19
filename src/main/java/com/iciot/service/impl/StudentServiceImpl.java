package com.iciot.service.impl;

import com.iciot.dao.StudentDao;
import com.iciot.domain.Student;
import com.iciot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 学生服务接口的实现类，实现了StudentService接口定义的业务方法
@Service
public class StudentServiceImpl implements StudentService {
    // 自动注入StudentDao，用于操作数据库
    @Autowired
    private StudentDao studentDao;

    @Override
    public void insert(Student student) {
        // 调用StudentDao的insert方法插入学生信息
        studentDao.insert(student);
    }

    @Override
    public void delete(int stuNO) {
        // 调用StudentDao的delete方法删除学生信息
        studentDao.delete(stuNO);
    }

    @Override
    public void update(Student student) {
        // 调用StudentDao的update方法更新学生信息
        studentDao.update(student);
    }

    @Override
    public List<Student> findAll() {
        // 调用StudentDao的findAll方法查询所有学生信息
        return studentDao.findAll();
    }

    @Override
    public Student findByStuNO(int stuNO) {
        // 调用StudentDao的findByStuNO方法根据学号查询学生信息
        return studentDao.findByStuNO(stuNO);
    }
    @Override
    public List<Student> fuzzySearchByName(String keyword) {
        return studentDao.fuzzySearchByName(keyword);
    }
}