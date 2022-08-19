package com.cognizant.auditchecklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.auditchecklist.entity.AuditQuestions;

public interface AuditQuestionRepository extends JpaRepository<AuditQuestions, Long> {

	List<AuditQuestions> findByType(String type);

}
