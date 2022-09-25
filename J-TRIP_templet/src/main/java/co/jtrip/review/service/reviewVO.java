package co.jtrip.review.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class reviewVO {	
	private String reviewNo;
	private String reviewTitle;
	private Date reviewDate;
	private String reviewContent;
	private String reviewScore;
	private String reviewImg;	
	private String memberId;	
	

}
