package com.csy.dao;

import com.csy.pojo.Admin;
import com.csy.pojo.Books;
import com.csy.pojo.BorrowInfo;
import com.csy.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int addStudent(Student student); //增加一名学生

    //@Param注解
    int deleteStudentById(@Param("student_id") String id); //根据id,删除一名学生

    int updateStudent(Student student); //更新一名学生信息

    Student queryStudentById(@Param("student_id") String id); //根据id,查询一名学生

    List<Student> queryAllStudents(); //查询所有学生

    Student queryStudentByName(@Param("student_name") String name); //根据名字查询学生

    Admin queryAdminByName(@Param("admin_name") String name);

    List<BorrowInfo> queryAllBorrowInfo(); //查询所有借阅信息
}
