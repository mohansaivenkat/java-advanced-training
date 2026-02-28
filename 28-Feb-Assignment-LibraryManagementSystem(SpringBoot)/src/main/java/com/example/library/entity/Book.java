package com.example.library.entity;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	private String title;
	@Column(unique = true)
	private String isbn;
	private int publishYear;
	private int copiesTotal;
	private int copiesAvailable;
	private String status; // (ACTIVE / INACTIVE)
	
	
	//mapping
	
	@ManyToMany
	@JoinTable(
			name="book_authors",
			joinColumns = @JoinColumn(name = "bookId"),
			inverseJoinColumns = @JoinColumn(name = "authorId")
	)
	
	private Set<Author> authors = new LinkedHashSet<Author>();
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "branchId")
	private LibraryBranch branch;
	
	
	@OneToMany(mappedBy = "book")
	private List<Loan> loans = new LinkedList<Loan>();
	
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LibraryBranch getBranch() {
		return branch;
	}
	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public int getCopiesTotal() {
		return copiesTotal;
	}
	public void setCopiesTotal(int copiesTotal) {
		this.copiesTotal = copiesTotal;
	}
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbn=" + isbn + ", publishYear=" + publishYear
				+ ", copiesTotal=" + copiesTotal + ", copiesAvailable=" + copiesAvailable + ", status=" + status + "]";
	}
	
	

}
