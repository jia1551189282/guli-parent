package com.atguigu.guli.service.oss.service;

import java.io.InputStream;

/**
 * @author zjiajia
 * @date 2020/9/7 20:45
 */


public interface FileService {
    /**
     * 文件上传到阿里云
     * @param inputStream   输入流
     * @param module        模块名
     * @param oFileName     文件名
     * @return              返回文件路径
     */
    String upload(InputStream inputStream,String module,String oFileName);
}
