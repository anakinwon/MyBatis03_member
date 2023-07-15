package com.spring.mybatis02;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.mybatis02.model.MybatisMember;
import com.spring.mybatis02.model.MybatisMemberMapper;

@Controller
@SessionAttributes("mybatisMember")
public class MybatisMemberController {	
	@Autowired
	MybatisMemberMapper mybatisMemberService;
	
	/** 
	 *  Test URL : http://localhost:8080/mybatis02/list
	 *           : 가입 회원 목록
	 * */
	@RequestMapping("/list")
	public void list(Model model){
		ArrayList<MybatisMember> mybatisMembers = 
				(ArrayList<MybatisMember>)mybatisMemberService.getAllMembers();
		
		model.addAttribute("mybatisMembers", mybatisMembers);
	}
	

	/** 
	 *  Test URL : http://localhost:8080/mybatis02/inputForm
	 *           : 회원 가입 화면
	 * */
	@RequestMapping("/inputForm")
	public void insertMember(Model model){
		model.addAttribute("mybatisMember",new MybatisMember());
	}//insertMember()
	
	@RequestMapping("/insertOk")
	public String insertOk(@Valid MybatisMember mybatisMember, BindingResult result){		
		if(result.hasErrors()){
			System.out.println("회원 가입시 오류가 발생하였습니다!!!!");
//			return "redirect:inputForm";
			return "inputForm"; //forward 방식
		}else{
			// 에러가 없으면 DB에 저장
			mybatisMemberService.insertMember(mybatisMember);
			return "redirect:list";
		}
	}//insertOk()
	

	/** 
	 *  Test URL : http://localhost:8080/mybatis02/modifyMember/{id}
	 *           : 회원 수정 화면
	 * */
	@RequestMapping("/modifyMember/{id}") //get방식 대신에 스프링에서 지원하는 방식 사용
	public String modifyMember(@PathVariable String id, Model model){
		model.addAttribute("mybatisMember",mybatisMemberService.getMember(id));
		return "modifyForm";
	}
	
	@RequestMapping("/modifyOk")
	public String modifyOk(@Valid MybatisMember mybatisMember, BindingResult result ){
		
		if(result.hasErrors()){
			System.out.println("회원정보 수정시 오류가 발생하였습니다!!!");
			return "modifyForm";
		}else{
			mybatisMemberService.updateMember(mybatisMember);
			return "redirect:list";
		}
	}//modifyOk()
	

	/** 
	 *  Test URL : http://localhost:8080/mybatis02/delMember/{id}
	 *           : 회원 삭제 화면
	 * */
	@RequestMapping("/delMember")
	public void delMember(Model model){
		model.addAttribute("mybatisMember", new MybatisMember());
	}
	
	@RequestMapping("/delMember/{id}")
	public String delMember(@PathVariable String id, Model model){		
//		model.addAttribute("mybatisMember", new MybatisMember());
		//id 존재 여부 체크
		if(mybatisMemberService.getMember(id) !=null){ //id 존재하는 경우
			model.addAttribute("mybatisMember", mybatisMemberService.getMember(id));			
			return "delMember";
		}else{ //id null인 경우
			return "delFail";
		}

	}//delMember
	
	@RequestMapping("/deleteOk")
	public String deleteOk(@Valid MybatisMember mybatisMember, BindingResult result){
//		if(result.hasErrors()) :hasErrors 여러개의 필드 오류를 체크한다. 따라서 여기서는 불필요한 작업
		if(result.getFieldErrorCount(mybatisMember.getId()) > 0){
			System.out.println("삭제 오류 발생하였습니다!!!!");
			return "delMember";
		}else{
			mybatisMemberService.deleteMember(mybatisMember.getId());
			return "redirect:list";
		}//if
	}//deleteOk()
	

	
}
