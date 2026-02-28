package com.example.library.service;

import java.util.List;

import com.example.library.entity.LibraryBranch;

public interface BranchService {

	LibraryBranch addBranch(LibraryBranch branch);

	LibraryBranch getBranchById(Long branchId);

	List<LibraryBranch> getAllBranches();

	LibraryBranch updateBranch(Long branchId, LibraryBranch updatedBranch);

	void deleteBranch(Long branchId);

}
