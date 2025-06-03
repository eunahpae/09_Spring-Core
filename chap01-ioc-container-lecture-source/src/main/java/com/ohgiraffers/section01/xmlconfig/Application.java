package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        /*
         * GenericXmlApplicationContext는 Spring의 ApplicationContext 구현체 중 하나로,
         * XML 파일을 통해 스프링 설정 정보를 읽어와 애플리케이션 컨텍스트를 초기화한다.
         * 아래 코드는 classpath 기준으로 "section01/xmlconfig/spring-context.xml"에 정의된
         * 스프링 빈 설정 정보를 로드한다.
         */
        ApplicationContext context = new GenericXmlApplicationContext(
            "section01/xmlconfig/spring-context.xml");

        /*
         * [Bean을 가져오는 3가지 방법]
         *
         * 1. 빈의 id를 이용해 가져오는 방법
         *    → XML 설정 파일에서 정의한 id("member")를 사용하여 Bean을 가져온다.
         *    → 반환 타입이 Object이므로 캐스팅이 필요하다.
         */
//        MemberDTO member = (MemberDTO) context.getBean("member");

        /*
         * 2. 빈의 클래스 타입을 이용해 가져오는 방법
         *    → 등록된 빈 중 해당 타입이 하나뿐일 경우 사용 가능하다.
         *    → 여러 개일 경우 예외 발생 (NoUniqueBeanDefinitionException)
         */
//        MemberDTO member = context.getBean(MemberDTO.class);

        /*
         * 3. 빈의 id와 클래스 타입을 함께 전달해 가져오는 방법
         *    → 가장 명확하고 안정적인 방식으로, id와 타입이 모두 일치하는 빈을 반환한다.
         *    → 명시적이기 때문에 다수의 동일 타입 빈이 존재해도 문제 없음
         */
        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println("member = " + member);

    }
}
