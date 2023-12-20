package com.sh.mvc.board.model.service;

import com.sh.mvc.board.model.entity.Board;
import com.sh.mvc.board.model.vo.BoardVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardServiceTest {
    BoardService boardService;

    public void beforeEach() { this.boardService = new BoardService(); }

    @DisplayName("Board객체는 null이 아니다.")
    @Test
    public void test1()
    {
        assertThat(boardService).isNotNull();
    }

    @DisplayName("전체 조회")
    @Test
    public void test2() {
        List<Board> boards = boardService.findAll();
        assertThat(boards)
                .isNotNull()
                .isNotEmpty();
        boards.forEach((board) -> {
            System.out.println(board);
            assertThat(board.getId()).isNotNull();
            assertThat(board.getTitle()).isNotNull();
            assertThat(board.getContent()).isNotNull();
            assertThat(board.getMemberId()).isNotNull();
            assertThat(board.getReadCount()).isNotNull();
            assertThat(board.getRegDate()).isNotNull();
        });

    }
    @DisplayName("한건 조회")
    @Test
    public void test3() {
        long id = 1;
        Board board = boardService.findById(id);
        System.out.println(board);
        assertThat(board).isNotNull();
        assertThat(board.getId()).isEqualTo(id);
        assertThat(board.getMemberId()).isNotNull();

    }
    @DisplayName("게시글 등록")
    @Test
    public void test4() {
//        String title = "추가";
//        String memberId = "abcde";
//        String content = "안녕하세요!";

        BoardVo board = new BoardVo();
        board.setTitle("제목");
        board.setContent("내용");

        int result = boardService.insertBoard(board);

        assertThat(result).isEqualTo(1);

    }
    @DisplayName("게시글 수정")
    @Test
    public void test5() {
        long id = 100;
        BoardVo board = boardService.findById(id);
        assertThat(board).isNotNull();

        String newTitle = "수정제목";
        String newContent = "수정내용";

        board.setTitle(newTitle);
        board.setContent(newContent);
        int result = boardService.updateBoard(board);

        assertThat(result).isGreaterThan(0);
        Board board1 = boardService.findById(id);
        assertThat(board1.getTitle()).isEqualTo(newTitle);
        assertThat(board1.getContent()).isEqualTo(newContent);
    }
    @DisplayName("게시글 삭제")
    @Test
    public void test6() {
        long id = 100;
        Board board = boardService.findById(id);
        assertThat(board).isNotNull();

        int result = boardService.deleteBoard(id);
        assertThat(result).isGreaterThan(0);
    }
    @DisplayName("전체 게시글 수 조회")
    @Test
    public void test7() {
        int totalCount = boardService.getTotalCount();
        System.out.println(totalCount);
        assertThat(totalCount).isNotNull();
        assertThat(totalCount).isLessThanOrEqualTo(0);

    }
    @DisplayName("게시글 페이징 조회")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void test8(int page) {
        assertThat(page).isGreaterThan(0);
        System.out.println(page);

        int limit = 10;
        Map<String, Object> param = Map.of("page", page, "limit", limit);
        List<BoardVo> boards = boardService.findAll(param);
        System.out.println(boards);

        assertThat(boards).isNotEmpty();
        assertThat(boards.size()).isLessThanOrEqualTo(limit);

    }

}
