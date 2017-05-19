package com.naver.dbtjd122.domain;

public class MailVO {
	private String from;
	private String tubject;
	private String gmsg;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTubject() {
		return tubject;
	}
	public void setTubject(String tubject) {
		this.tubject = tubject;
	}
	public String getGmsg() {
		return gmsg;
	}
	public void setGmsg(String gmsg) {
		this.gmsg = gmsg;
	}
	@Override
	public String toString() {
		return "MailVO [from=" + from + ", tubject=" + tubject + ", gmsg=" + gmsg + "]";
	}
	
	
}
