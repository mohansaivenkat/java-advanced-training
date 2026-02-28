package com.example.library.service;

import java.util.List;

import com.example.library.entity.Member;

public interface MemberService {

	Member addMember(Member member);

	Member getMemberById(Long memberId);

	List<Member> getAllMembers();

	Member updateMember(Long memberId, Member updatedMember);

	void deleteOrDisableMember(Long memberId);

}
