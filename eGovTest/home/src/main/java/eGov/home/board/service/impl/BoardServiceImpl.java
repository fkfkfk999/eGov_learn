package eGov.home.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import eGov.home.board.service.BoardService;
import eGov.home.board.domain.BoardDefaultVO;
import eGov.home.board.domain.BoardVO;
import eGov.home.board.dao.BoardDAO;
import eGov.home.board.dao.BoardMapper;
/**
 * @Class Name : BoardServiceImpl.java
 * @Description : Board Business Implement class
 * @Modification Information
 *
 * @author fkfkfk9
 * @since 2021-06-11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("boardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements
        BoardService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

    @Resource(name="boardMapper")
    private BoardMapper boardDAO;
    
    //@Resource(name="boardDAO")
    //private BoardDAO boardDAO;
    
    /** ID Generation */
    //@Resource(name="{egovBoardIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * board을 등록한다.
	 * @param vo - 등록할 정보가 담긴 BoardVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBoard(BoardVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	boardDAO.insertBoard(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * board을 수정한다.
	 * @param vo - 수정할 정보가 담긴 BoardVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBoard(BoardVO vo) throws Exception {
        boardDAO.updateBoard(vo);
    }

    /**
	 * board을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BoardVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBoard(BoardVO vo) throws Exception {
        boardDAO.deleteBoard(vo);
    }

    /**
	 * board을 조회한다.
	 * @param vo - 조회할 정보가 담긴 BoardVO
	 * @return 조회한 board
	 * @exception Exception
	 */
    public BoardVO selectBoard(BoardVO vo) throws Exception {
        BoardVO resultVO = boardDAO.selectBoard(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * board 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return board 목록
	 * @exception Exception
	 */
    public List<?> selectBoardList(BoardDefaultVO searchVO) throws Exception {
        return boardDAO.selectBoardList(searchVO);
    }

    /**
	 * board 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return board 총 갯수
	 * @exception
	 */
    public int selectBoardListTotCnt(BoardDefaultVO searchVO) {
		return boardDAO.selectBoardListTotCnt(searchVO);
	}
    
}
