package com.basic.todo.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class ToDoTask extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String summary;
	private String descr;
	private Boolean status;

	public ToDoTask() {
	}

	public ToDoTask(String summary, String descr, Boolean status) {
		this.summary = summary;
		this.descr = descr;
		this.status = status;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}