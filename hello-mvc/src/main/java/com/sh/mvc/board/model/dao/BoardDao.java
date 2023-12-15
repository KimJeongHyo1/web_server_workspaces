package com.sh.mvc.board.model.dao;

import com.sh.mvc.board.model.entity.Board;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BoardDao {
    public List<Board> findAll(SqlSession session) {
        return session.selectList("board.findAll");
    }
}
