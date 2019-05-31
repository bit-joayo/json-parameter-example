package com.bit.controller;

public class Jamong {
	 String storyNo;
	 String title;
	 String storyContent;
	public String getStoryNo() {
		return storyNo;
	}
	public void setStoryNo(String storyNo) {
		this.storyNo = storyNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStoryContent() {
		return storyContent;
	}
	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}
	@Override
	public String toString() {
		return "Jamong [storyNo=" + storyNo + ", title=" + title + ", storyContent=" + storyContent + "]";
	}
	
	
	
	
}
