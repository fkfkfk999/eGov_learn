package egovframework.learn.testboard.model;

import lombok.Data;


public @Data class TestBoardVO {
	/* TestBoard Table
	 * `seqno` int(11) NOT NULL AUTO_INCREMENT COMMENT 'pk',
	  `title` varchar(100) DEFAULT NULL COMMENT '제목',
	  `contents` varchar(1000) DEFAULT NULL COMMENT '내용',
	  `writer` varchar(100) DEFAULT NULL COMMENT '작성자',
	  `attachment` varchar(100) DEFAULT NULL COMMENT '첨부파일',
	  `regdate` datetime DEFAULT NULL COMMENT '등록일',
	  */
	private String seqno;
	private String title;
	private String contents;
	private String writer;
	private String attachment;
	private String regdate;
}
