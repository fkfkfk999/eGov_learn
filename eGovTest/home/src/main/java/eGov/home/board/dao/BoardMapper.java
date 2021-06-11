package eGov.home.board.dao;

import java.util.List;

import eGov.home.board.domain.BoardVO;
import eGov.home.board.domain.BoardDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : BoardMapper.java
 * @Description : Board Mapper Class
 * @Modification Information
 *
 * @author fkfkfk9
 * @since 2021-06-11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("boardMapper")
public interface BoardMapper {

	/**
	 * board을 등록한다.
	 * @param vo - 등록할 정보가 담긴 BoardVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertBoard(BoardVO vo) throws Exception;

    /**
	 * board을 수정한다.
	 * @param vo - 수정할 정보가 담긴 BoardVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBoard(BoardVO vo) throws Exception;

    /**
	 * board을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BoardVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBoard(BoardVO vo) throws Exception;

    /**
	 * board을 조회한다.
	 * @param vo - 조회할 정보가 담긴 BoardVO
	 * @return 조회한 board
	 * @exception Exception
	 */
    public BoardVO selectBoard(BoardVO vo) throws Exception;

    /**
	 * board 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return board 목록
	 * @exception Exception
	 */
    public List<?> selectBoardList(BoardDefaultVO searchVO) throws Exception;

    /**
	 * board 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return board 총 갯수
	 * @exception
	 */
    public int selectBoardListTotCnt(BoardDefaultVO searchVO);

}
