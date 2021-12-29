package com.gestbibliotheq.bib.mail;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Email {

	 public static final String myMail = "ab7tasso@gmail.com";
	 
	 public static final String myPassWord = "ab.tasso@2020";
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idM;
	 private String cosmail;
	 private String object;
	 private String msg;
	 private Date datSend;
	public Email() {
		super();
		
	}
	public Email(String cosmail, String object, String msg, Date datSend) {
		super();
		this.cosmail = cosmail;
		this.object = object;
		this.msg = msg;
		this.datSend = datSend;
	}
	public String getCosmail() {
		return cosmail;
	}
	public void setCosmail(String cosmail) {
		this.cosmail = cosmail;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getDatSend() {
		return datSend;
	}
	public void setDatSend(Date datSend) {
		this.datSend = datSend;
	}
	@Override
	public String toString() {
		return "Email [cosmail=" + cosmail + ", object=" + object + ", msg=" + msg + ", datSend=" + datSend + "]";
	}
	 
	 
	
	

}
