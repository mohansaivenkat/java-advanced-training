package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.dao.LibraryBranchRepository;
import com.example.library.entity.LibraryBranch;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private LibraryBranchRepository branchRepository;

	@Override
	public LibraryBranch addBranch(LibraryBranch branch) {
		return branchRepository.save(branch);
	}

	@Override
	public LibraryBranch getBranchById(Long branchId) {
		return branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("brnach not found with id " + branchId));
	}

	@Override
	public List<LibraryBranch> getAllBranches() {
		return branchRepository.findAll();
	}

	@Override
	public LibraryBranch updateBranch(Long branchId, LibraryBranch updatedBranch) {
		LibraryBranch existing = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("brnach not found with id " + branchId));
		existing.setName(updatedBranch.getName());
		existing.setLocation(updatedBranch.getLocation());
		existing.setContactNumber(updatedBranch.getContactNumber());
		return branchRepository.save(existing);
	}

	@Override
	public void deleteBranch(Long branchId) {
		LibraryBranch existing = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("brnach not found with id " + branchId));
		branchRepository.delete(existing);
	}

}
