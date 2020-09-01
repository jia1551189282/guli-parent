package com.atguigu.guli.service.edu.service;

import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.query.TeacherQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Helen
 * @since 2020-09-01
 */
public interface TeacherService extends IService<Teacher> {
    /**
     *

     * 条件分页查询
     * @param page          当前页
     * @param limit         每页条数
     * @param teacherQuery  条件查询
     * @return              分页信息（mybatisPlus 封装的）
     */


    Page<Teacher> selectPage(Long page, Long limit, TeacherQuery teacherQuery);
}
