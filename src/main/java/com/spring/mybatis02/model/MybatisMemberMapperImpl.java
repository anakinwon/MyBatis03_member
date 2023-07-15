package com.spring.mybatis02.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service
@Repository
public class MybatisMemberMapperImpl implements MybatisMemberMapper{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<MybatisMember> getAllMembers(){
/*		List<MybatisMember> members= new ArrayList<MybatisMember>();
		MybatisMemberMapper mybatisMemberMapper 
		 =sqlSession.getMapper(MybatisMemberMapper.class);
		
		//members = mybatisMemberMapper.getAllMembers();
		
	    //return members;
		
		return mybatisMemberMapper.getAllMembers();*/
		
		return sqlSession.selectList("getAllMembers");
	}
	
	@Override
	public MybatisMember getMember(String id){
/*		MybatisMemberMapper mybatisMemberMapper = 
				sqlSession.getMapper(MybatisMemberMapper.class);
		
		return mybatisMemberMapper.getMember(id);*/
		
		return sqlSession.selectOne("getMember",id);
	}
	
	@Override
	public void insertMember(MybatisMember mybatisMember){
/*		MybatisMemberMapper mybatisMemberMapper =
				sqlSession.getMapper(MybatisMemberMapper.class);
		mybatisMemberMapper.insertMember(mybatisMember);*/
		
		sqlSession.insert("insertMember",mybatisMember);
	}
	
	@Override
	public void updateMember(MybatisMember mybatisMember){
		/*MybatisMemberMapper mybatisMemberMapper =
				sqlSession.getMapper(MybatisMemberMapper.class);
		mybatisMemberMapper.updateMember(mybatisMember);*/
		
		sqlSession.update("updateMember", mybatisMember);	
	}
	
	@Override
	public void deleteMember(String id){
		/*MybatisMemberMapper mybatisMemberMapper=
				sqlSession.getMapper(MybatisMemberMapper.class);
		mybatisMemberMapper.deleteMember(id);*/
		
		sqlSession.delete("deleteMember", id);
	}
}
