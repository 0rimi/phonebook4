package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value="/phone")
public class PhoneController {
	
	//필드(공통으로 쓰는 phoneDao빼주기)
	@Autowired //나 이거 필요해!(com.javaex..밑은 다 해당)
	private PhoneDao phoneDao;
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController > writeForm");
		
		return "writeForm";
	}
	
	//파라미터를 직접 갖다 쓸수가 없음 frontController에서 받아오는작업필요
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > write");
		
		System.out.println(personVo);
		
		phoneDao.personInsert(personVo);
		
		//리다이렉트
		return "redirect:/phone/list";	
	}
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) { //컨트롤러에서 모델을 통해 프론트컨트롤러로 보내!
		System.out.println("PhoneController > list");
		
		//다오에서 리스트를 가져온다
		List<PersonVo> pList = phoneDao.getPersonList();
		
		//mvc패턴 : 모델, 컨트롤러, 뷰
		//컨트롤러 > DS데이터를 보낸다(model)
		model.addAttribute("pList", pList);
		
		//jsp정보를 리턴한다.(view)
		return "list";
	}
	
	@RequestMapping(value="/updateForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(@RequestParam("no") int no, Model model) { //컨트롤러에서 모델을 통해 프론트컨트롤러로 보내!
		System.out.println("PhoneController > updateForm");
		
		//원래 코드값으로부터 정보 불러와서 미리 넣어주는 getPerson이용
		PersonVo pinfo = phoneDao.getPerson(no);
				
		//mvc패턴 : 모델, 컨트롤러, 뷰
		//컨트롤러 > DS데이터를 보낸다(model)
		model.addAttribute("pinfo", pinfo);
		
		return "updateForm";
	}
	
	@RequestMapping(value="/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > update");
		
		//수정할 값불러와서 personUpdate 해주기
		phoneDao.personUpdate(personVo);
		
		//리다이렉트
		return "redirect:/phone/list";	
	}
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhoneController > delete");
				
		//삭제할 값불러와서 personDelete 해주기		
		phoneDao.personDelete(no);
		
		//리다이렉트
		return "redirect:/phone/list";	
	}
	
//	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST})
//	public String test(@RequestParam(value="name") String name,
//					   @RequestParam(value="age",required=false, defaultValue="-1") int age) {		
//									//혹시나 param값이 없으면 만들어서라도 받아줘, 연결해줘
//		System.out.println(name);
//		System.out.println(age);
//		
//		return "writeForm";
//	}
	
	/*
	//파라미터를 직접 갖다 쓸수가 없음 frontController에서 받아오는작업필요
	@RequestMapping(value="/phone/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company) {
		System.out.println("PhoneController > write");
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		PersonVo personVo = new PersonVo(name, hp, company);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		
		return "";	
	}
	*/
								//파라미터사용
	@RequestMapping(value="/view", method= {RequestMethod.GET, RequestMethod.POST})
	public String view(@RequestParam(value="no") int no) {		
									
		System.out.println("@RequestParam");
		System.out.println(no+"번 글 가져오기");
		
		return "writeForm";
	}
								//주소를 변수화 하고싶어, 파라미터는 아님!
	@RequestMapping(value="/view/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String view11(@PathVariable("no") int no) {		
				
		System.out.println("PathVariable");
		System.out.println(no+"번 글 가져오기");
		
		return "writeForm";
	}
	
	@RequestMapping(value="/view/{id}", method= {RequestMethod.GET, RequestMethod.POST})
	public String view13(@PathVariable("id") String id) {		
				
		System.out.println(id+"의 블로그입니다.");		
		
		return "writeForm";
	}
	

}
