package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /*
         * AnnotationConfigApplicationContext
         * - 자바 기반(@Configuration) 설정 클래스를 사용하여 스프링 컨테이너를 초기화할 때 사용하는 클래스이다.
         * - 생성자의 인자로 넘긴 클래스(ContextConfiguration.class)는
         *   @Configuration 어노테이션이 붙은 스프링 설정 클래스여야 한다.
         * - 이 설정 클래스를 기반으로 내부에 정의된 @Bean 메서드들이 실행되어 Bean 객체가 등록된다.
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(
            ContextConfiguration.class);

        /*
         * getBean 메서드
         * - 첫 번째 인자는 빈 이름("member"), 두 번째 인자는 빈 타입(MemberDTO.class)을 의미한다.
         * - ContextConfiguration 클래스에서 @Bean(name = "member")로 등록된 객체를 가져온다.
         */
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println("member = " + member);

    }

}
