package com.csy.service;

import com.csy.pojo.Admin;
import com.csy.pojo.BorrowInfo;
import com.csy.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    int addStudent(Student student); //增加一名学生

    //@Param注解
    int deleteStudentById(String id); //根据id,删除一名学生

    int updateStudent(Student student); //更新一名学生信息

    Student queryStudentById(String id); //根据id,查询一名学生

    List<Student> queryAllStudents(); //查询所有学生

    Student queryStudentByName(String name); //根据名字查询学生

    Boolean login(String name, String password); //管理员登录

    Boolean StuLogin(String name, String password); //学生登录

    List<BorrowInfo> queryAllBorrowInfo(); //查询所有借阅信息

    List<BorrowInfo> queryStudentBorrowInfo(String name); //根据学生姓名，查询其所对应的借阅信息

}
