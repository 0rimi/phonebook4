package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository //저장소의 개념으로 쓸거니까 (applicationContext참고)
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<PersonVo> getPersonList(){
		System.out.println("PhoneDao.getPersonList()");
		
		List<PersonVo> pList = sqlSession.selectList("phonebook.selectList");		
		System.out.println(pList);
		
		return pList;
	}
	
	/*
	//추가
	public int personInsert(PersonVo personVo) {
		System.out.println("PhoneDao.personInsert()");
		
		int count = sqlSession.insert("phonebook.insert",personVo);
		System.out.println(count+"건이 추가되었습니다.");
		
		return count;
	}
	*/
	
	//추가
	public int personInsert(PersonVo personVo) {
		System.out.println("PhoneDao.personInsert() 파라미터 여러개 받을때");
	
		//자료형이 다 다르면 String,Object
		Map<String, String> personMap = new HashMap<String, String>();
		personMap.put("uname", personVo.getName());
		personMap.put("uhp", personVo.getHp());
		personMap.put("ucompany", personVo.getCompany());
		System.out.println(personMap);
		
		int count = sqlSession.insert("phonebook.insert",personMap);
		System.out.println(count+"건이 추가되었습니다.");
		
		return count;
	}
	
	
	//삭제
	public int personDelete(int personId) {
		System.out.println("PhoneDao.personDelete()");
		
		int count = sqlSession.delete("phonebook.delete", personId);
		System.out.println(count+"건이 삭제되었습니다.");
		
		return count;
	}
	
	
	//특정한 사람 불러오기
	public PersonVo getPerson(int no) {
		System.out.println("PhoneDao.getPerson");
		
		PersonVo personVo = sqlSession.selectOne("phonebook.selectone", no);
		
		
		return personVo;
	}
	
	/*
	//특정한 사람 불러오기
		public Map<String, Object> getPerson(int no) {
			System.out.println("PhoneDao.getPerson");
			
			Map<String, Object> personMap = sqlSession.selectOne("phonebook.selectone");
			System.out.println(personMap.keySet());
			System.out.println(personMap);
			
			System.out.println(personMap.get("NAME"));
			System.out.println(personMap.get("PERSON_ID"));
			
			return personMap;
		}
	*/	
	
	
	//업데이트
	public int personUpdate(PersonVo personVo) {
		System.out.println("PhoneDao.personUpdate");
		
		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count+"건이 수정되었습니다.");
		
		return count;
	}

}
