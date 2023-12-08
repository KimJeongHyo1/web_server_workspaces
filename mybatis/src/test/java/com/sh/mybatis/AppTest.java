package com.sh.mybatis;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

/**
 * JUnit 테스트 구성요소
 * 1. fixture method : 매 테스트 전후작업
 *   - fixture 테스트대상 또는 테스트에 필요한 객체
 *   - 모든 테스트는 독립적으로 진행됨(매번 새로운 테스트객체를 생성 후 진행)
 *   - @BeforeAll, @AfterAll (static)
 *   - @BeforeEach, @AfterEach
 *
 * 2. 단정문 (assertion)
 *   - 코드실행결과는 이것이다~로 단정함(
 *   - assertThat(...)
 *   - assertNotNull(...)
 *   - ...
 *
 * 3. TestRunner : 테스트주체
 *
 */
public class AppTest { // 전체 실행됨
//    App app = new App();
    App app;

    // fixture메소드
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll"); // 제일 먼저 실행
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll"); // 제일 마지막에 실행
    }
    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach"); //
        this.app = new App();
    }
    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    @DisplayName("App#sum메소드 - 두수의 합을 반환 하는지 테스트")
    @Test
    public void test() {
//        fail("구현 예정!");  // 처음에 확인(?)하려고 이렇게 많이 만듦
        int result = app.sum(10, 20);
        assertThat(result).isEqualTo(30);


        result = app.sum(30, 5);
        assertThat(result).isEqualTo(35);
    }
    @DisplayName("App#random은 1 ~ 100사이의 정수를 반환 하는지 테스트")
    @Test
    public void test2() {
        System.out.println("(test2)");
        // 뒤에 나오는 글씨는 반환 타입을 의미함
        int n = app.random();
        System.out.println(n); // 숫자 몇 나오는지 확인
        assertThat(n)
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(100);
    }
}
