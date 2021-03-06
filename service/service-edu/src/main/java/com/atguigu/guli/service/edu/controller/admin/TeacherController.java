package com.atguigu.guli.service.edu.controller.admin;


import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.query.TeacherQuery;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "讲师管理")
@CrossOrigin
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有讲师
     * @return      讲师列表
     */
    @ApiOperation(value = "所有讲师列表",notes = "查询所有的讲师列表")
    @GetMapping("/list")
    public R listTeacher(){
        List<Teacher> list = teacherService.list();
        return R.ok().data("items",list);
    }

    /**
     * 根据id删除讲师
     * @param id    讲师id
     * @return      返回处理结果
     */
    @ApiOperation(value = "根据id删除讲师",notes = "根据id删除，逻辑删除")
    @DeleteMapping("/remove/{id}")
    public R removeById(
            @ApiParam(value = "讲师id",required = true)
            @PathVariable("id") String id
    ){
        boolean b = teacherService.removeById(id);
        if(b){
            return R.ok().message("删除成功");
        }else {
            return R.error().message("删除失败，讲师不存在");
        }
    }

    /**
     * 带条件的分页查询
     * @param page      第几页
     * @param limit     每页条数
     * @param teacherQuery  条件构造对象
     * @return              分页结果
     */
    @ApiOperation("条件分页查询讲师")
    @GetMapping("list/{page}/{limit}")
    public R listPage(
            @ApiParam(value = "当前页",required = true)
            @PathVariable("page")Long page,
            @ApiParam(value = "分页",required = true)
            @PathVariable("limit")Long limit,
            @ApiParam("讲师条件查询对象")
            TeacherQuery teacherQuery
    ){

        Page<Teacher> teacherPage = teacherService.selectPage(page, limit, teacherQuery);
        return R.ok().data("items",teacherPage);
    }

    /**
     * 新增讲师
     * @param  teacher  讲师信息
     * @return          返回结果
     */
    @ApiOperation("新增讲师")
    @PostMapping("/save")
    public R save(
            @ApiParam("讲师对象信息")
            @RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        if(save){
            return R.ok().message("新增成功");
        }else {
            return R.error().message("新增失败");
        }
    }

    /**
     * 根据id修改讲师信息
     * @param teacher   讲师信息
     * @return          返回结果
     */
    @ApiOperation("修改讲师信息")
    @PutMapping("update")
    public R update(
            @ApiParam("讲师对象")
            @RequestBody Teacher teacher
    ){
        boolean b = teacherService.updateById(teacher);
        if(b){
            return R.ok().message("修改成功");
        }else {
            return R.error().message("修改失败");
        }
    }

    /**
     *
     * @param id  讲师id
     * @return    讲师信息
     *
     */
    @ApiOperation("根据id查询讲师信息")
    @GetMapping("{id}")
    public R getById(@PathVariable("id") String  id){
        Teacher teacher = teacherService.getById(id);

        int i = 10/0;
        return R.ok().data("teacher",teacher);
    }

}

