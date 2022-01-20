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
	
	
	
	/*
		// 사람 수정
	public int personUpdate(PersonVo personVo) {
		int count = 0;
		getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " update person ";
			query += " set name = ? , ";
			query += "     hp = ? , ";
			query += "     company = ? ";
			query += " where person_id = ? ";

			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setString(1, personVo.getName()); // ?(물음표) 중 1번째, 순서중요
			pstmt.setString(2, personVo.getHp()); // ?(물음표) 중 2번째, 순서중요
			pstmt.setString(3, personVo.getCompany()); // ?(물음표) 중 3번째, 순서중요
			pstmt.setInt(4, personVo.getPersonId()); // ?(물음표) 중 4번째, 순서중요

			count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리
			System.out.println(count + "건 수정되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		close();
		return count;
	}

	*/
}
