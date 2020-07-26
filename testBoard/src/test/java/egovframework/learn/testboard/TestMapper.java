package egovframework.learn.testboard;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import egovframework.learn.testboard.mapper.TestBoardMapper;
import egovframework.learn.testboard.model.TestBoardVO;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { 
		"file:src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-servlet.xml", 
		"file:src/main/resources/egovframework/spring/com/*.xml"
		})
@WebAppConfiguration
public class TestMapper {
	
	@Resource(name = "testBoardMapper")
	private TestBoardMapper mapper;
	
	@Test
	public void selectAllTest() {
		List<TestBoardVO> list;
		TestBoardVO tbvo = new TestBoardVO();
		tbvo.setTitle("title");
		tbvo.setContents("contents");
		tbvo.setWriter("writer");
		
		try {
			int result = mapper.insertTestBoard(tbvo);
			System.out.println("Input Result ==========> " + result);
			if(result == 1) {
				list = mapper.getTestBoardAllList();
				for (TestBoardVO vo : list) {
					System.out.println(vo.toString());
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
