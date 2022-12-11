package com.csy.service;

import com.csy.dao.AdminMapper;
import com.csy.pojo.Admin;
import com.csy.pojo.BorrowInfo;
import com.csy.pojo.StuBorrowInfo;
import com.csy.pojo.Student;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    //业务层调用DAO层
    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public int addStudent(Student student) {
        return adminMapper.addStudent(student);
    }

    @Override
    public int deleteStudentById(String id) {
        return adminMapper.deleteStudentById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return adminMapper.updateStudent(student);
    }

    @Override
    public Student queryStudentById(String id) {
        return adminMapper.queryStudentById(id);
    }

    @Override
    public List<Student> queryAllStudents() {
        return adminMapper.queryAllStudents();
    }

    @Override
    public Student queryStudentByName(String name) {
        return adminMapper.queryStudentByName(name);
    }

    @Override
    public Boolean login(String name, String password) {
        Admin admin = adminMapper.queryAdminByName(name);
        if (admin != null) {
            return admin.getAdmin_password().equals(password);
        }
        return false;
    }

    @Override
    public Boolean StuLogin(String name, String password) {
        Student student = adminMapper.queryStudentByName(name);
        if (student != null) {
            return student.getStudent_password().equals(password);
        }
        return false;
    }

    @Override
    public List<BorrowInfo> queryAllBorrowInfo() {
        return adminMapper.queryAllBorrowInfo();
    }

    @Override
    public List<StuBorrowInfo> queryStudentBorrowInfo(String name) {
        return adminMapper.queryStudentBorrowInfo(name);
    }
}
