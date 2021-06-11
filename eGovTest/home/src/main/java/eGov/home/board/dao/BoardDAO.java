package eGov.home.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import eGov.home.board.domain.BoardVO;
import eGov.home.board.domain.BoardDefaultVO;

/**
 * @Class Name : BoardDAO.java
 * @Description : Board DAO Class
 * @Modification Information
 *
 * @author fkfkfk9
 * @since 2021-06-11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("boardDAO")
public class BoardDAO extends EgovAbstractDAO {

	/**
	 * board을 등록한다.
	 * @param vo - 등록할 정보가 담긴 BoardVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBoard(BoardVO vo) throws Exception {
        return (String)insert("boardDAO.insertBoard_S", vo);
    }

    /**
	 * board을 수정한다.
	 * @param vo - 수정할 정보가 담긴 BoardVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBoard(BoardVO vo) throws Exception {
        update("boardDAO.updateBoard_S", vo);
    }

    /**
	 * board을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BoardVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBoard(BoardVO vo) throws Exception {
        delete("boardDAO.deleteBoard_S", vo);
    }

    /**
	 * board을 조회한다.
	 * @param vo - 조회할 정보가 담긴 BoardVO
	 * @return 조회한 board
	 * @exception Exception
	 */
    public BoardVO selectBoard(BoardVO vo) throws Exception {
        return (BoardVO) select("boardDAO.selectBoard_S", vo);
    }

    /**
	 * board 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return board 목록
	 * @exception Exception
	 */
    public List<?> selectBoardList(BoardDefaultVO searchVO) throws Exception {
        return list("boardDAO.selectBoardList_D", searchVO);
    }

    /**
	 * board 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return board 총 갯수
	 * @exception
	 */
    public int selectBoardListTotCnt(BoardDefaultVO searchVO) {
        return (Integer)select("boardDAO.selectBoardListTotCnt_S", searchVO);
    }

}
