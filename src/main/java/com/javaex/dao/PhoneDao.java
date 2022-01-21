package com.javaex.dao;

import java.util.List;

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
	
	
	//추가
	public int personInsert(PersonVo personVo) {
		System.out.println("PhoneDao.personInsert()");
		
		int count = sqlSession.insert("phonebook.insert",personVo);
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
	
	//업데이트
	public int personUpdate(PersonVo personVo) {
		System.out.println("PhoneDao.personUpdate");
		
		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count+"건이 수정되었습니다.");
		
		return count;
	}

}
