package co.jtrip.review.service;

import java.util.List;

public interface reviewService {
	List<reviewVO> reviewSelectList();
	reviewVO reviewSelect(reviewVO vo);  
	int reviewInsert(reviewVO vo);
	int reviwUpdate(reviewVO vo);
	int reivewDelete(reviewVO vo);
	
	//boolean isIdCheck(String id);  

}
