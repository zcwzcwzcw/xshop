package com.xshop.controller.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.aliyun.oss.OSSClient;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传控制器
 * @author zcw
 * @date 2019/11/12
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private HttpServletRequest request;

    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    private static final String accessKeyId = "LTAI4Fp5w2rbzVf81J4asuTG";
    private static final String secretAccessKey = "cadsChZN1juLUo1kEbW1vkHO7gem76";


    /**
     * 上传文件至本地
     */
    @PostMapping("/native.do")
    public String nativeUpload(MultipartFile file) {
        String path = request.getSession().getServletContext().getRealPath("img");
        File destFile = new File(path + "/" + file.getOriginalFilename());
        if (!destFile.getParentFile().exists()) {
            destFile.mkdirs();
        }
        try {
            file.transferTo(destFile);
        } catch (IOException e) {
            throw new RuntimeException("上传本地文件失败" + e.getMessage());
        }
        return "http://localhost:9101/img/" + file.getOriginalFilename();
    }

    /**
     * 上传文件至oss
     * TODO 将OSSClient变为bean
     */
    @PostMapping("/oss.do")
    public String nativeOss(MultipartFile file, String folder) {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, secretAccessKey);
        String bucketName = "zcwmall";
        String fileName = folder + "/" + UUID.randomUUID() + file.getOriginalFilename();
        try {
            ossClient.putObject(bucketName, fileName, file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("上传oss文件失败" + e.getMessage());
        }
        System.out.println("图片");
        return "https://" + bucketName + "." + endpoint + "/" + fileName;
    }


}
