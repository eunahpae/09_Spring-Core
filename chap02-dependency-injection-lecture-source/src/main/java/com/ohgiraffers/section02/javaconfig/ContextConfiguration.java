package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Configuration
 * - 해당 클래스가 스프링의 설정 클래스임을 명시한다.
 * - 자바 코드 기반으로 빈을 등록할 수 있게 해준다.
 */
@Configuration
public class ContextConfiguration {

    /*
     * @Bean
     * - 스프링 컨테이너에 등록할 객체를 반환하는 메서드에 붙인다.
     * - 메서드 이름(accountGenerator)이 빈의 이름이 된다.
     */
    @Bean
    public Account accountGenerator() {
        return new PersonalAccount("110-234-567890", 1000);
    }

    /*
     * MemberDTO 타입의 빈을 등록하는 메서드
     * 생성자 주입 방식과 setter 주입 방식 두 가지 중 setter 방식 사용
     */
    @Bean
    public MemberDTO memberGenerator() {

        // 1. 생성자 주입 방식 (주석 처리)
//        return new MemberDTO(1, "홍길동", "010-123-4567", "hong123@gmail.com", accountGenerator());

        // 2. setter 주입 방식
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("홍길동");
        member.setPhone("010-123-1234");
        member.setEmail("hong123@gmail.com");
        member.setPersonalAccount(accountGenerator());

        return member;
    }
}
