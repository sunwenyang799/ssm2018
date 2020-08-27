package com.springmvc.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 16:10 2020/8/27
 * @ Description：
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 传统文件上传方式：
     *      使用apache的commons-fileupload(依赖commons-io)
     * @param request
     * @param username
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    public String fileUpload(HttpServletRequest request,String username) throws Exception {
        System.out.println("传统方式上传文件");
        //使用fileUpload组件进行上传
        //上传位置:当前项目的绝对路径
//        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        String path  = "D:/DownLoad/uploads/";
        File file = new File(path);
        //判断是否有这个文件夹，没有就创建一个
        if(!file.exists()){
            file.mkdirs();
        }

        //解析request对象。获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> fileItems = fileUpload.parseRequest(request);
        for (FileItem item : fileItems) {
            //进行判断，当前item是否是上传文件项
            if(item.isFormField()){
                //说明是普通表单项
                String fieldName = item.getFieldName();
                System.out.println(fieldName);
                //获取普通表单项的值
                 String value = new String(item.getString().getBytes("ISO-8859-1"), "utf-8");
                 System.out.println(value);
            }else{
                //获取上传文件名称
                String fieldName = item.getName();
                //获取uuid避免文件上传文件名称重复
                String uuid = UUID.randomUUID().toString().replace("-", "");
                //完成文件上传
                item.write(new File(path,uuid+"_"+fieldName));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * springmvc方式上传需要配置CommonsMultipartResolver
     * 表单其他参数也可以直接在方法参数中获取
     * @param file
     * @param username
     * @return
     */
    @RequestMapping(value = "/springmvcFileUpload",method = RequestMethod.POST)
    public String springmvcFileUpload(MultipartFile file,String username){
        System.out.println("springmvc方式上传文件");
        String path = "D:/DownLoad/uploads/";
        File file1 = new File(path);
        if(!file1.exists()){
            file1.mkdirs();
        }
        //获取文件原名称
        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        try {
            file.transferTo(new File(path,uuid+"_"+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 跨服器文件上传
     * @param file
     * @return
     */
    @RequestMapping(value = "/clientFileUpload",method = RequestMethod.POST)
    public String clientFileUpload(MultipartFile file) throws IOException {
        System.out.println("跨服务器方式上传文件");
        String path = "http://localhost:9090/Storage_war_exploded/uploads/";
        File file1 = new File(path);
        if(!file1.exists()){
            file1.mkdirs();
        }

        //获取文件原名称
        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");

        //创建客户端对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource resource = client.resource(path+filename);
        //上传文件
        resource.put(file.getBytes());

        return "success";
    }
}
