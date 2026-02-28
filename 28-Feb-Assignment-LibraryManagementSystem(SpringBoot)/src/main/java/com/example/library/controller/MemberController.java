package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.Member;
import com.example.library.service.MemberService;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping
	public ResponseEntity<Member> createMember(@RequestBody Member member) {
		return ResponseEntity.ok(memberService.addMember(member));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
		return ResponseEntity.ok(memberService.getMemberById(id));
	}

	@GetMapping
	public ResponseEntity<List<Member>> getAllMembers() {
		return ResponseEntity.ok(memberService.getAllMembers());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
		return ResponseEntity.ok(memberService.updateMember(id, member));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable Long id) {
		memberService.deleteOrDisableMember(id);
		return ResponseEntity.ok("member disabeld succesfully");
	}

}
