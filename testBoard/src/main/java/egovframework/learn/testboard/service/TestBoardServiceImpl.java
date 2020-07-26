package egovframework.learn.testboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.learn.testboard.mapper.TestBoardMapper;
import egovframework.learn.testboard.model.TestBoardVO;

@Service("testBoardService")
public class TestBoardServiceImpl implements TestBoardService {
	
	@Resource(name = "testBoardMapper")
	private TestBoardMapper testBoardMapper;
	
	@Override
	public List<TestBoardVO> getTestBoardAllList() throws Exception {
		System.out.println("===============================> service!!");
		List<TestBoardVO> list = testBoardMapper.getTestBoardAllList();
		for (TestBoardVO vo : list) {
			System.out.println(vo.toString());
		}
		return list;
	}

}
