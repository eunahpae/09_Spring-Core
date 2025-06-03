package com.ohgiraffers.section01.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/*
 * @Repository
 * - 이 클래스가 데이터 액세스 계층(DAO) 역할을 한다는 것을 Spring에게 알림.
 * - "bookDAO"라는 이름으로 스프링 컨테이너에 Bean으로 등록된다.
 */
@Repository("bookDAO")
public class BookDAOImpl implements BookDAO {

    /*
     * 실제 데이터베이스 대신 도서 정보를 저장할 임시 Map 컬렉션.
     * Key는 도서 일련번호(sequence), Value는 도서 정보를 담은 BookDTO 객체.
     */
    private final Map<Integer, BookDTO> bookList;

    /*
     * 생성자에서 도서 목록을 초기화한다.
     * - 실제 DB 연동 없이 하드코딩된 도서 데이터를 저장함.
     */
    public BookDAOImpl() {
        bookList = new HashMap<>();
        bookList.put(1, new BookDTO(1, 123456, "자바의 정석", "남궁성", "도우출판", new java.util.Date()));
        bookList.put(2,
            new BookDTO(2, 678900, "칭찬은 고래도 춤추게 한다", "고래", "고래출판", new java.util.Date()));
    }

    /*
     * 전체 도서 목록을 조회하여 List 형태로 반환한다.
     */
    @Override
    public List<BookDTO> selectBookList() {
        return new ArrayList<>(bookList.values());
    }

    /*
     * 일련번호(sequence)를 기반으로 특정 도서를 조회하여 반환한다.
     */
    @Override
    public BookDTO selectOneBook(int sequence) {
        return bookList.get(sequence);
    }

    /*
     * [왜 BookDAOImpl 같은 Impl 클래스가 필요한가?]
     *
     * 1. 역할 분리
     *    - BookDAO 인터페이스는 '무엇을 할지(기능의 정의)'만 선언하고,
     *    - BookDAOImpl은 '어떻게 할지(구현)'를 제공한다.
     *
     * 2. 유연한 확장과 유지보수
     *    - 나중에 JDBC, JPA, MyBatis 등 다른 기술로 구현체를 바꿔도
     *      인터페이스는 그대로 두고 구현체만 교체하면 된다.
     *
     * 3. 테스트 용이성
     *    - 테스트 환경에서는 BookDAOImpl 대신 가짜(Mock) 구현체를 만들어
     *      쉽게 단위 테스트를 할 수 있다.
     *
     * 4. DI(의존성 주입) 기반 프로그래밍
     *    - Spring이 인터페이스(BookDAO)를 기준으로 구현체(BookDAOImpl)를 자동 주입해줌으로써
     *      느슨한 결합(Loosely Coupled)을 구현할 수 있다.
     */
}
