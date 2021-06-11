package eGov.home.board.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import eGov.home.board.service.BoardService;
import eGov.home.board.domain.BoardDefaultVO;
import eGov.home.board.domain.BoardVO;

/**
 * @Class Name : BoardController.java
 * @Description : Board Controller class
 * @Modification Information
 *
 * @author fkfkfk9
 * @since 2021-06-11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=BoardVO.class)
public class BoardController {

    @Resource(name = "boardService")
    private BoardService boardService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * board 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 BoardDefaultVO
	 * @return "/board/BoardList"
	 * @exception Exception
	 */
    @RequestMapping(value="/board/BoardList.do")
    public String selectBoardList(@ModelAttribute("searchVO") BoardDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> boardList = boardService.selectBoardList(searchVO);
        model.addAttribute("resultList", boardList);
        
        int totCnt = boardService.selectBoardListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/board/BoardList";
    } 
    
    @RequestMapping("/board/addBoardView.do")
    public String addBoardView(
            @ModelAttribute("searchVO") BoardDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("boardVO", new BoardVO());
        return "/board/BoardRegister";
    }
    
    @RequestMapping("/board/addBoard.do")
    public String addBoard(
            BoardVO boardVO,
            @ModelAttribute("searchVO") BoardDefaultVO searchVO, SessionStatus status)
            throws Exception {
        boardService.insertBoard(boardVO);
        status.setComplete();
        return "forward:/board/BoardList.do";
    }
    
    @RequestMapping("/board/updateBoardView.do")
    public String updateBoardView(
            @RequestParam("seqno") int seqno ,
            @ModelAttribute("searchVO") BoardDefaultVO searchVO, Model model)
            throws Exception {
        BoardVO boardVO = new BoardVO();
        boardVO.setSeqno(seqno);        
        // 변수명은 CoC 에 따라 boardVO
        model.addAttribute(selectBoard(boardVO, searchVO));
        return "/board/BoardRegister";
    }

    @RequestMapping("/board/selectBoard.do")
    public @ModelAttribute("boardVO")
    BoardVO selectBoard(
            BoardVO boardVO,
            @ModelAttribute("searchVO") BoardDefaultVO searchVO) throws Exception {
        return boardService.selectBoard(boardVO);
    }

    @RequestMapping("/board/updateBoard.do")
    public String updateBoard(
            BoardVO boardVO,
            @ModelAttribute("searchVO") BoardDefaultVO searchVO, SessionStatus status)
            throws Exception {
        boardService.updateBoard(boardVO);
        status.setComplete();
        return "forward:/board/BoardList.do";
    }
    
    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(
            BoardVO boardVO,
            @ModelAttribute("searchVO") BoardDefaultVO searchVO, SessionStatus status)
            throws Exception {
        boardService.deleteBoard(boardVO);
        status.setComplete();
        return "forward:/board/BoardList.do";
    }

}
