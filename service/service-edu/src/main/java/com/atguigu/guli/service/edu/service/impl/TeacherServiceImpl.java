package com.atguigu.guli.service.edu.service.impl;

import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.query.TeacherQuery;
import com.atguigu.guli.service.edu.mapper.TeacherMapper;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Helen
 * @since 2020-09-01
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Page<Teacher> selectPage(Long page, Long limit, TeacherQuery teacherQuery) {

        Page<Teacher> pageParam  = new Page<>(page,limit);

        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();

        queryWrapper.orderByAsc("sort");

        if(teacherQuery == null){
            return teacherMapper.selectPage(pageParam,queryWrapper);
        }

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String  joinDateBegin = teacherQuery.getJoinDateBegin();
        String  joinDateEnd = teacherQuery.getJoinDateEnd();

        if(!StringUtils.isEmpty(name)){
            queryWrapper.likeRight("name",name);
        }

        if(level != null){
            queryWrapper.eq("level",level);
        }

        if(!StringUtils.isEmpty(joinDateBegin)){
            queryWrapper.ge("join_date",joinDateBegin);
        }

        if(!StringUtils.isEmpty(joinDateEnd)){
            queryWrapper.le("join_date",joinDateEnd);
        }
        Page<Teacher> teacherPage = teacherMapper.selectPage(pageParam, queryWrapper);
        return teacherPage;
    }
}
