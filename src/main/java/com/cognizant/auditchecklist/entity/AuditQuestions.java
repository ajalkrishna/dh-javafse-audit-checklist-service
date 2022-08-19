package com.cognizant.auditchecklist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditQuestions {

	@Id
	private long id;
	private String question;
	private String type;
}
