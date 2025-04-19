package com.iciot.dao;

import com.iciot.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

// MyBatis的Mapper接口，用于定义与学生信息相关的数据库操作
@Mapper
public interface StudentDao {
    // 插入学生信息到数据库，使用MyBatis的注解方式定义SQL语句
    // #{stuNO}等是占位符，会自动将对应的实体类属性值传入SQL
    @Insert("INSERT INTO student (stuNO, name, sex, nation, telephone, birthday, address, photo, resume) " +
            "VALUES (#{stuNO}, #{name}, #{sex}, #{nation}, #{telephone}, #{birthday}, #{address}, #{photo}, #{resume})")
    void insert(Student student);

    // 根据学号删除学生信息
    @Delete("DELETE FROM student WHERE stuNO = #{stuNO}")
    void delete(int stuNO);

    // 更新学生信息，根据学号更新对应的学生记录
    @Update("UPDATE student SET name = #{name}, sex = #{sex}, nation = #{nation}, telephone = #{telephone}, " +
            "birthday = #{birthday}, address = #{address}, photo = #{photo}, resume = #{resume} WHERE stuNO = #{stuNO}")
    void update(Student student);

    // 查询所有学生信息，返回一个学生实体类的列表
    @Select("SELECT * FROM student")
    List<Student> findAll();

    // 根据学号查询单个学生信息
    @Select("SELECT * FROM student WHERE stuNO = #{stuNO}")
    Student findByStuNO(int stuNO);
    // 学生信息模糊查询
    @Select("SELECT * FROM student WHERE name LIKE CONCAT('%', #{keyword}, '%')")
    List<Student> fuzzySearchByName(String keyword);
}