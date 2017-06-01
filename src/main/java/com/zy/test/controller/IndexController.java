package com.zy.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy.test.aspectj.TestforAspectJ;
import com.zy.test.beans.ltw.LTWBean;
import com.zy.test.controller.request.GradeAndClassroomModel;
import com.zy.test.domain.NewsInfo;
import com.zy.test.domain.PageInfo;
//import com.zy.test.self.annotation.Log;
import com.zy.test.service.NewService;

@Controller
public class IndexController {
@Autowired
private NewService newService;

	/**
	 * Index
	 * @param model
	 * @param request
	 */
	@RequestMapping(value={"","/","index"})
	public String index(Model model, HttpServletRequest request) {
		String page = request.getParameter("page");
		page = StringUtils.defaultIfBlank(page, "1");
		int pageNumber = Integer.valueOf(page);
		
		int total = newService.findCount();
		PageInfo<NewsInfo> pageInfo = new PageInfo<>(total, pageNumber);
		pageInfo.setList(newService.findAll(pageInfo.getPageStart()));
		
		model.addAttribute("page", pageInfo);
		return "index";
	}
	
	/**
	 * Detail
	 * @param model
	 * @param id
	 */
	@RequestMapping("detail/{id}")
	public String detail(Model model, @PathVariable int id) {		
		model.addAttribute("info", newService.findOne(id));
		return "detail";
	}
	
	/**
	 * @param request
	 * @return
	 */
	@RequestMapping("/test/Interceptor")
	//@Log
	public String interceptor(HttpServletRequest request) {
		
		return "hello";
	}
	
	@RequestMapping("/test/hello")
	//@Log
	public String hello(HttpServletRequest request) {
		return "hello";
	}
	
	@RequestMapping("/test/aspectj")
	public String aspectj(HttpServletRequest request) {
		TestforAspectJ testforAspectJ=new TestforAspectJ();
		testforAspectJ.cut();
//		
//		System.out.println("我是/test/aspectj的hello：");
//		helloWorldService.getHelloMessage();
		LTWBean ltwBean=new LTWBean();
		ltwBean.run();
		ltwBean.test();
		System.out.println("执行完毕~~~");
		return "hello";
	}
	
	//使用验证的格式
	@RequestMapping("/test/valid")
    @ResponseBody
    public String say(@Valid GradeAndClassroomModel bean, BindingResult bindingResult){       
        return bindingResult.hasErrors() ?
        bindingResult.getFieldError().getDefaultMessage() : "incorrect";
    }
}