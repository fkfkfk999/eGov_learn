package egovframework.learn.testboard.mapper;

import java.util.List;

import egovframework.learn.testboard.model.TestBoardVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("testBoardMapper")
public interface TestBoardMapper {
	public List<TestBoardVO> getTestBoardAllList();
	public TestBoardVO getTestBoardView(String seqno);
	public int insertTestBoard(TestBoardVO vo);
	public int updateTestBoard(TestBoardVO vo);
	public int deleteTestBoard(String seqno);
}
