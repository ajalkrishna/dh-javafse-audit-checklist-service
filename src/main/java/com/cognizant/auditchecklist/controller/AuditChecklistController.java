package com.cognizant.auditchecklist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.auditchecklist.entity.AuditQuestions;
import com.cognizant.auditchecklist.model.Response;
import com.cognizant.auditchecklist.repository.AuditQuestionRepository;
import com.cognizant.auditchecklist.service.ValidateToken;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/audit-checklist")
@Slf4j
public class AuditChecklistController {

	@Autowired
	private AuditQuestionRepository repo;

	@Autowired
	private ValidateToken validateToken;

	@GetMapping("/AuditCheckListQuestions/{type}")
	public ResponseEntity<Response> getAuditCheckListQuestions(@PathVariable String type,
			@RequestHeader(name = "Authorization",required=true) String bearerToken) {
		List<AuditQuestions> auditQuestions;
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			
			String token = bearerToken.substring(7);
			
			log.info("token available");
			if (validateToken.isValidToken(token)) {
				try {
					auditQuestions = repo.findByType(type);
					log.info("audit-questions-available");
				} catch (Exception ex) {
					log.info("Something went wrong");
					return new ResponseEntity<>(new Response("Something went wrong",null), HttpStatus.OK);
				}
				return new ResponseEntity<>(new Response("audit questions available",auditQuestions), HttpStatus.OK);
			}
			else {
				log.info("invalid token");
				return new ResponseEntity<>(new Response("Something went wrong",null), HttpStatus.OK);
			}
			
		} else {
			log.info("token unavailable, Bearer keyword missing");
			return new ResponseEntity<>(new Response("Something went wrong",null), HttpStatus.OK);
		}
	}

}
