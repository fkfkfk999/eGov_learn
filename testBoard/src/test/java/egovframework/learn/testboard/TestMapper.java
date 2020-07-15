package egovframework.learn.testboard;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import egovframework.learn.testboard.mapper.TestBoardMapper;
import egovframework.learn.testboard.model.TestBoardVO;

public class TestMapper {

	@Resource(name = "testBoardMapper")
	private TestBoardMapper testBoardMapper;
	
	@Test
	public void selectAllTest() {
		System.out.println("select start!!");
		
		/*List<TestBoardVO> list;
		try {
			list = testBoardMapper.getTestBoardAllList();
			for (TestBoardVO vo : list) {
				System.out.println(vo.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		*/
		
		TestBoardVO vo = new TestBoardVO();
		vo.setTitle("title");
		vo.setContents("contents");
		vo.setWriter("writer");
		
		try {
			testBoardMapper.insertTestBoard(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
