package com.sh.mybatis.member.model.dao;

import com.sh.mybatis.member.model.entity.Member;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MemberDao {

    public Member findById(SqlSession session, String id) {
        // 한건조회는 selectOne 여러건조회는 selectList
        // SqlSession#selectOne("namespace.id", param) // 쿼리에는 where id = ?작성
        return session.selectOne("member.findById", id); // namespace.값, 쿼리
    }

    public List<Member> findAll(SqlSession session) {
        return session.selectList("member.findAll");
    }
    public List<Member> findByName(SqlSession session, String name) {
        return session.selectList("member.findByName", name);
    }

    public List<Member> findByGender(SqlSession session, String gender) {
        return session.selectList("member.findByGender", gender);
    }

    public int insertMember(SqlSession session, Member member) {
        return session.insert("member.insertMember", member);
    }

    public int updateMember(SqlSession session, Member member) {
        return session.update("member.updateMember", member);
    }

    public int updateMemberPassword(SqlSession session, Member member) {
        return session.update("member.updateMemberPassword", member);
    }

    public int updateMemberRole(SqlSession session, Member member) {
        return session.update("member.updateMemberRole", member);
    }

    public int deleteMember(SqlSession session, String id) {
        return session.delete("member.deleteMember", id);
    }
}

