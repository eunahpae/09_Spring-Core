package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Configuration
 * - 해당 클래스가 스프링의 설정 클래스임을 나타낸다.
 * - XML 설정 파일을 대체하며, @Bean 어노테이션과 함께 사용된다.
 */
@Configuration
public class ContextConfiguration {

    /*
     * @Bean
     * - 해당 메서드가 반환하는 객체를 스프링 컨테이너에 Bean으로 등록한다.
     * - name 속성을 지정하면 해당 이름으로 등록되고,
     *   지정하지 않으면 메서드 이름(getMember)이 빈 이름으로 사용된다.
     *   → 예: name 생략 시 "getMember"라는 이름의 빈으로 등록됨
     *   @Bean("member") 또는 @Bean(name = "member")의 형식으로 빈 이름(id)을 설정할 수 있다.
     */
    @Bean(name = "member")
    public MemberDTO getMember() {

        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }

}
