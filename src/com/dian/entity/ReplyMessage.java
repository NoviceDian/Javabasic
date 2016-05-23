package com.dian.entity;

import java.util.Date;

public class ReplyMessage {

	private Integer id;
	private String replyContent;
	private Integer eid;
	private Date replyTime;
	private Integer mid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

}
