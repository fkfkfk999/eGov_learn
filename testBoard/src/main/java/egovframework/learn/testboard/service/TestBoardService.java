package egovframework.learn.testboard.service;

import java.util.List;

import egovframework.learn.testboard.model.TestBoardVO;

public interface TestBoardService {
	public List<TestBoardVO> getTestBoardAllList() throws Exception;
}
