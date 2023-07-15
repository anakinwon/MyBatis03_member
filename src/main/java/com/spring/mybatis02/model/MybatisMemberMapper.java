package com.spring.mybatis02.model;

import java.util.List;

//DAO와 같은 역할
public interface MybatisMemberMapper {
	
	// 회원 목록 조회하기.
	public List<MybatisMember> getAllMembers();

	// 회원 상세보기.
	public MybatisMember getMember(String id);

	// 회원 저장하기.
	public void insertMember(MybatisMember mybatisMember);

	// 회원 수정하기.
	public void updateMember(MybatisMember mybatisMember);

	// 회원 삭제하기.
	public void deleteMember(String id);
}
