package com.example.demo;/**
 * Created by jazzyshi on 2019/9/19.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UploadController
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/19 15:41
 * @Version 1.0
 **/
@RestController
public class UploadController {

    @RequestMapping("/picUpload")
    public Map<String,Object> fileUpload(@RequestParam("filename") MultipartFile file) throws IOException {

        System.out.println(file.getOriginalFilename());

        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String path = "c:/test/aa" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }

        file.transferTo(dest);

        Map<String,Object> maps = new HashMap<>();
        maps.put("msg","ok");

        return maps;
    }

}
