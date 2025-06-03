package com.ohgiraffers.section03.annotationconfig;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /*
         * AnnotationConfigApplicationContext
         * - 자바 기반 설정 클래스(ContextConfiguration)를 통해 스프링 컨테이너를 초기화한다.
         * - 해당 설정 클래스는 @Configuration 어노테이션을 가지고 있어야 하며,
         *   내부적으로 @ComponentScan 등을 통해 자동으로 빈을 등록한다.
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(
            ContextConfiguration.class);

        /*
         * getBeanDefinitionNames()
         * - 현재 스프링 컨테이너에 등록된 모든 Bean의 이름(ID)을 문자열 배열로 반환한다.
         * - 이를 통해 어떤 빈들이 등록되었는지 확인할 수 있다.
         */
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        /*
         * 스프링 컨테이너에서 memberDAO라는 이름으로 등록된 Bean을 가져온다.
         * - @Component 어노테이션에 의해 자동 등록된 MemberDAO 객체이다.
         */
        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);

        // ID 1번 회원 조회
        System.out.println(memberDAO.selectMember(1));

        // 새 회원 등록 (ID 3)
        System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03", "pass03", "신사임당")));

        // ID 3번 회원 조회
        System.out.println(memberDAO.selectMember(3));
    }

}
