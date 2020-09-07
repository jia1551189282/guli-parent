package com.atguigu.guli.service.oss.service.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.atguigu.guli.service.oss.service.FileService;
import com.atguigu.guli.service.oss.util.OssProperties;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author zjiajia
 * @date 2020/9/7 20:46
 */

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private OssProperties ossProperties;



    @Override
    public String upload(InputStream inputStream, String module, String oFileName) {
        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyId();
        String keysecret = ossProperties.getKeySecret();
        String bucketname = ossProperties.getBucketName();




        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);

        // 构建路径
        String folder = new DateTime().toString("yyyy/MM/dd");

        // 文件名： uuid.扩展名
        String fileName = UUID.randomUUID().toString();
        String fileExtension = oFileName.substring(oFileName.lastIndexOf("."));
        String key = module + "/" + folder + "/" + fileName + fileExtension;

        ossClient.putObject(bucketname, key, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();


        //返回url地址
        return "https://" + bucketname + "." + endpoint + "/" + key;
    }
}
