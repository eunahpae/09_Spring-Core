package com.ohgiraffers.common;

/**
 * PersonalAccount 클래스는 개인 계좌 정보를 표현하며, Account 인터페이스를 구현하여 입출금 및 잔액 조회 기능을 제공한다.
 */
public class PersonalAccount implements Account {

    private String accNo; // 계좌 번호
    private int balance;  // 계좌 잔액

    /**
     * 기본 생성자. Spring과 같은 프레임워크에서 객체 생성 후 setter나 DI를 통해 값을 주입할 수 있도록 한다.
     */
    public PersonalAccount() {
    }

    /**
     * 모든 필드를 초기화하는 생성자.
     *
     * @param accNo   계좌 번호
     * @param balance 초기 잔액
     */
    public PersonalAccount(String accNo, int balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    /**
     * 현재 잔액을 문자열로 반환한다.
     *
     * @return 잔액을 문자열로 반환
     */
    @Override
    public String getBalance() {
        return this.balance + "";
    }

    /**
     * 전달된 금액을 잔액에 더하여 입금 처리한다.
     *
     * @param money 입금할 금액
     * @return 입금 성공 시 true 반환
     * @throws IllegalArgumentException 입금 금액이 0인 경우 예외 발생
     */
    @Override
    public boolean deposite(int money) {
        if (money == 0) {
            throw new IllegalArgumentException("입금할 금액이 잘못되었습니다.");
        }
        this.balance += money;
        return true;
    }

    /**
     * 전달된 금액을 잔액에서 차감하여 출금 처리한다.
     *
     * @param money 출금할 금액
     * @return 출금 성공 시 true 반환
     * @throws IllegalArgumentException 출금 금액이 잔액을 초과하는 경우 예외 발생
     */
    @Override
    public boolean withDraw(int money) {
        if (money > this.balance) {
            throw new IllegalArgumentException("잔액보다 큰 금액을 출금할 수 없습니다.");
        }
        this.balance -= money;
        return true;
    }
}
