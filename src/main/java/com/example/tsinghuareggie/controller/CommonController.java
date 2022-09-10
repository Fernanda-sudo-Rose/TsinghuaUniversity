package com.example.tsinghuareggie.controller;

import com.example.tsinghuareggie.common.CustomException;
import com.example.tsinghuareggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Value("${tsinghua.path}")
    private String basePath;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {
        //这个file是一个临时文件，需要转存到指定位置，否则本次请求完成后临时文件会删除
        log.info(file.toString());

        // 原始文件名
        String originalFilename = file.getOriginalFilename();
        //拿到文件的后缀名 比如 .png  .jpg
        //String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String suffix = null;
        if (originalFilename != null) {
            suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        // 使用UUID重新生成文件名，防止文件名称重复造成文件覆盖
        String fileName = UUID.randomUUID() + suffix;

        // 创建一个目录对象
        File dir = new File(basePath);
        // 判断当前目录是否存在
        if (!dir.exists()) {
            // 目录不存在，需要创建
            if (!dir.mkdirs()) {
                 throw new CustomException("目录不存在，创建失败");
            }
        }

        try {
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return R.success(fileName);
    }

    /**
     * 文件下载
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) {

        //输入流，通过输入流读取文件内容 这里的name是前台用户需要下载的文件的文件名

        try {
            //new File(basePath + name) 是为了从存储图片的地方获取用户需要的图片对象
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
            // 输出流，通过输出流将文件写回浏览器中
            ServletOutputStream outputStream = response.getOutputStream();

            // 设置写回去的文件类型
            response.setContentType("image/jpeg");

            // 定义缓冲区，准备写文件
            int len = 0;
            byte[] buff = new byte[1024];
            while ((len = fileInputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
                outputStream.flush();
            }
            //关流
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
