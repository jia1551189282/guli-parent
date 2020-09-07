package com.atguigu.guli.service.oss.controller;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zjiajia
 * @date 2020/9/7 20:56
 *
 * 文件上传控制层
 */

@Api(tags = "阿里云文件管理")
@CrossOrigin
@RestController
@RequestMapping("admin/oss/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation("文件上传")
    @PostMapping("upload")
    public R upload(
            @ApiParam("文件")
            @RequestParam("file")
            MultipartFile file ,
            @ApiParam("模块名")
            @RequestParam("module")
            String module) throws IOException {
        InputStream inputStream = file.getInputStream();

        String originalFilename = file.getOriginalFilename();

        String uploadUrl = fileService.upload(inputStream, module, originalFilename);

        return R.ok().message("文件上传成功").data("url",uploadUrl);
    }



}
