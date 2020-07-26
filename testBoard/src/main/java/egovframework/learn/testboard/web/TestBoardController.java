package egovframework.learn.testboard.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.learn.testboard.service.TestBoardService;

@Controller
@RequestMapping(value = "/board")
public class TestBoardController {
	
	@Resource(name = "testBoardService")
	private TestBoardService testBoardService;
	
	@RequestMapping(value = "/AllList.do")
	public String testBoardAllList(Model model) throws Exception{
		System.out.println("===============================> start!!");
		model.addAttribute("resultList", testBoardService.getTestBoardAllList());
		return "/board/allList";
	}
}
