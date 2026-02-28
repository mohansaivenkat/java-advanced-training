package com.example.library.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.dao.MemberRepository;
import com.example.library.entity.Member;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public Member addMember(Member member) {
		member.setMemberSince(LocalDate.now());
		member.setStatus("ACTIVE");
		return memberRepository.save(member);
	}

	@Override
	public Member getMemberById(Long memberId) {
		return memberRepository.findById(memberId)
				.orElseThrow(() -> new ResourceNotFoundException("membar not found with id " + memberId));
	}

	@Override
	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	@Override
	public Member updateMember(Long memberId, Member updatedMember) {
		Member existing = memberRepository.findById(memberId)
				.orElseThrow(() -> new ResourceNotFoundException("membar not found with id " + memberId));
		existing.setName(updatedMember.getName());
		existing.setEmail(updatedMember.getEmail());
		existing.setPhone(updatedMember.getPhone());
		return memberRepository.save(existing);
	}

	@Override
	public void deleteOrDisableMember(Long memberId) {
		Member existing = memberRepository.findById(memberId)
				.orElseThrow(() -> new ResourceNotFoundException("membar not found with id " + memberId));
		existing.setStatus("BLOCKED");
		memberRepository.save(existing);
	}

}
