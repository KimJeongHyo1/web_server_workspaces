package com.sh.mybatis.member.model.dao;

import com.sh.mybatis.member.model.entity.Member;
import org.apache.ibatis.session.SqlSession;

public class MemberDao {

    public Member findById(SqlSession session, String id) {
        // 한건조회는 selectOne 여러건조회는 selectList
        // SqlSession#selectOne("namespace.id", param) // 쿼리에는 where id = ?작성
        return session.selectOne("member.findById", id);
    }
}
