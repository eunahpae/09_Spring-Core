package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDTO;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /*
         * AnnotationConfigApplicationContext 생성자에 패키지명을 전달하여
         * 해당 패키지 내에서 @Component, @Service, @Repository 등의 어노테이션이 붙은
         * 컴포넌트를 자동으로 스캔하고 Spring 컨테이너에 빈으로 등록한다.
         * 즉, 컴포넌트 스캔 기능을 활성화시키는 방법 중 하나이다.
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(
            "com.ohgiraffers.section01");

        /*
         * Spring 컨테이너로부터 "bookServiceField"라는 이름의 빈을
         * BookService 타입으로 가져온다.
         * 여기서 "bookServiceField"는 BookService 구현체 빈의 이름이며,
         * 필드 주입(@Autowired)을 사용한 버전임을 나타낸다.
         */
        BookService bookService = context.getBean("bookServiceField", BookService.class);

        /*
         * BookService를 통해 전체 도서 목록을 조회한다.
         * 반환된 도서 리스트를 반복문으로 순회하며 각각의 도서 정보를 출력한다.
         */
        List<BookDTO> books = bookService.selectAllBooks();
        for (BookDTO book : books) {
            System.out.println("book = " + book);
        }

    }

}
