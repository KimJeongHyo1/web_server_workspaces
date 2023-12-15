package com.sh.mvc.board.model.service;

import com.sh.mvc.board.model.dao.BoardDao;
import com.sh.mvc.board.model.entity.Board;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.mvc.common.SqlSessionTemplate.getSqlSession;

public class BoardService {
    private BoardDao boardDao = new BoardDao();

    public List<Board> findAll() {
        SqlSession session = getSqlSession();
        List<Board> board = boardDao.findAll(session);
        session.close();
        return board;
    }
}
