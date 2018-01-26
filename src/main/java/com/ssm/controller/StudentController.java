package com.ssm.controller;

import com.ssm.domain.BaseResult;
import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 18/1/25.
 */
@Controller
public class StudentController {

    @Resource // 声明Service层中的对外接口对象
    private StudentService studentService;


    /**
     * 配置起始页
     *
     * @return
     */
    @RequestMapping(value = {"", "/"})
    public String index() {
        return "index";
    }

    // 获取学生列表数据,用于前端页面表格显示
    // 返回数据以json格式
    @RequestMapping(value = "/searchStudent")
    @ResponseBody
    public BaseResult<Student> searchStudent() {

        List<Student> students = studentService.selectAll();
        // 查询到的结果集进行封装
        BaseResult<Student> result = new BaseResult<>();
        result.setTotal(100);// 设置总记录数
        result.setData(students);// 设置当页显示数据
        return result;
    }


    /**
     * 分页查询
     * pageIndex和pageSize分别是miniUI前端传递过来的参数
     * student 接收前端野马传递过来的参数
     */
    @RequestMapping(value = "/findStudent")
    @ResponseBody
    public BaseResult<Student> findStudent(int pageIndex,int pageSize,Student student){
        // 调用分页查询业务
        BaseResult<Student> result = studentService.pageSelect(pageIndex,pageSize,student);

        return result;
    }


}
