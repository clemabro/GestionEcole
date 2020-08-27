package org.gestionecole.beans;

import java.sql.Date;

public class Note extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -345302145805172399L;
	
	private String note;
	private Date date;
	
	/**
	 * @param note
	 * @param date
	 */
	public Note(String note, Date date) {
		this.note = note;
		this.date = date;
	}

	/**
	 * 
	 */
	public Note() {
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
