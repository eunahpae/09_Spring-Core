package com.ohgiraffers.section03.annotationconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * @Configuration
 * - 해당 클래스가 스프링의 설정 클래스임을 나타낸다.
 * - 자바 기반 설정 방식에서 사용되며, XML 설정을 대체한다.
 *
 * @ComponentScan
 * - 지정된 패키지(com.ohgiraffers) 이하에서 @Component, @Service, @Repository, @Controller 등의
 *   어노테이션이 붙은 클래스를 스캔하여 빈으로 자동 등록한다.
 * - basePackages를 생략하면 해당 설정 클래스가 속한 패키지를 기준으로 스캔이 시작된다.
 *
 * 참고: 스프링은 역할에 따라 다음과 같은 어노테이션을 제공한다.
 *   - @Component   : 일반적인 컴포넌트 클래스
 *   - @Controller  : 프레젠테이션 계층 (웹 요청 처리)
 *   - @Service     : 비즈니스 로직 계층
 *   - @Repository  : 데이터 접근 계층
 *   - @Configuration : 설정 클래스
 */
@Configuration
@ComponentScan(basePackages = "com.ohgiraffers")
public class ContextConfiguration {

}
