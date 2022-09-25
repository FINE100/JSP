package co.jtrip.mybatis.mapper;

import java.util.List;

import co.jtrip.review.service.reviewVO;

public interface reviewMapper {
	List<reviewVO> reviewSelectList();
	reviewVO reviewSelect(reviewVO vo);  
	int reviewInsert(reviewVO vo);
	int reviwUpdate(reviewVO vo);
	int reivewDelete(reviewVO vo);

}
