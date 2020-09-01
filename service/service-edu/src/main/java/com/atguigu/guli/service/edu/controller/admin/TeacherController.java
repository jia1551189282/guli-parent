package com.atguigu.guli.service.edu.controller.admin;


import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Helen
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/list")
    public List<Teacher> listTeacher(){
        return teacherService.list();
    }

}

