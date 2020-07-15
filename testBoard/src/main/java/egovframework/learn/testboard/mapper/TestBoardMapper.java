package egovframework.learn.testboard.mapper;

import java.util.List;

import egovframework.learn.testboard.model.TestBoardVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("testBoardMapper")
public interface TestBoardMapper {
	public List<TestBoardVO> getTestBoardAllList() throws Exception;
	public TestBoardVO getTestBoardView(String seqno) throws Exception;
	public int insertTestBoard(TestBoardVO vo) throws Exception;
	public int updateTestBoard(TestBoardVO vo) throws Exception;
	public int deleteTestBoard(String seqno) throws Exception;
}
