package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookServiceField")  // BookService 클래스를 'bookServiceField'라는 이름의 서비스 빈으로 등록한다.
public class BookService {

    /*
     * BookDAO 타입의 빈(Bean) 객체를 이 필드에 자동으로 주입해준다.
     * Spring이 컴포넌트 스캔을 통해 BookDAO 구현체(BookDAOImpl)를 찾아
     * 이 필드에 자동으로 연결(Auto-wiring)한다.
     */
    @Autowired
    private BookDAO bookDAO;

    /* 전체 도서 목록을 조회하여 반환하는 메서드 */
    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    /* 도서 번호(일련번호)로 특정 도서를 조회하여 반환하는 메서드 */
    public BookDTO searcgBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
