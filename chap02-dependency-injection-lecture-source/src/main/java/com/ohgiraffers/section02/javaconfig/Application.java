package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* AnnotationConfigApplicationContext를 이용해 자바 설정 클래스를 기반으로 ApplicationContext 생성
         * ContextConfiguration.class는 @Configuration 어노테이션이 붙은 설정 클래스이다.
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(
            ContextConfiguration.class);

        /* MemberDTO 타입의 Bean을 컨테이너로부터 가져옴 (타입 기준 조회) */
        MemberDTO member = context.getBean(MemberDTO.class);
        System.out.println("member = " + member);

        /* member 객체 내부의 Account 객체 활용 예제 */
        Account account = member.getPersonalAccount();
        System.out.println(account.getBalance());             // 현재 잔액 출력
        System.out.println(account.deposite(10000));          // 1만원 입금
        System.out.println(account.getBalance());             // 잔액 확인
        System.out.println(account.withDraw(5000));           // 5천원 출금
        System.out.println(account.getBalance());             // 최종 잔액 확인
    }
}
