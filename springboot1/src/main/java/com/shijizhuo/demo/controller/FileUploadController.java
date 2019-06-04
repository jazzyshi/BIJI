package com.shijizhuo.demo.controller;/**
 * Created by jazzyshi on 2019/6/3.
 */

import org.apache.ibatis.ognl.IntHashMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FileUploadController
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/6/3 19:08
 * @Version 1.0
 **/
@RestController //表示该类下的方法的返回值会自动做json格式的转换
public class FileUploadController {

    @RequestMapping("/upload")
    public Map<String,Object> fileUpload(MultipartFile filename) throws IOException {
        System.out.println(filename.getOriginalFilename());

        File file = new File("c:/jzshi/"+filename.getOriginalFilename());
        if(!file.exists()){
            file.createNewFile();
        }
        filename.transferTo(file);

        Map<String,Object> map = new HashMap();
        map.put("msg","ok");
        return map;
    }
}
