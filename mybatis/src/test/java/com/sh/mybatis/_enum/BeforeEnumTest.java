package com.sh.mybatis._enum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BeforeEnumTest {
    public static final String TYPE_MEMBER = "M";
    public static final String TYPE_ADMIN = "A";
    public static final String GENDER_MALE = "M";
    public static final String GENDER_FEMALE = "F";

    public class Member {
        String id;
        String type; // M(Member), A(Admin)
        String gender; // M, F

        public Member(String id, String type, String gender) {
            this.id = id;
            this.type = type;
            this.gender = gender;
        }
    }

    @Test
    public void test1() {
        Member member = new Member("honggd", TYPE_MEMBER, GENDER_MALE);
//        Member member = new Member("honggd", GENDER_MALE, )
        assertThat(member.type).isEqualTo(TYPE_MEMBER);
        assertThat(member.gender).isEqualTo(GENDER_MALE);

        // ctrl, alt, y하면 같은 단어 전부 수정해줌
        Member admin = new Member("sinsa", TYPE_ADMIN, GENDER_FEMALE);
        assertThat(admin.type).isEqualTo(TYPE_ADMIN);
        assertThat(admin.gender).isEqualTo(GENDER_FEMALE);
    }
    
}
