package com.ohgiraffers.common;

public interface Account {

    /* 잔액 조회 */
    String getBalance();

    /* 입금 */
    boolean deposite(int money);

    /* 출금 */
    boolean withDraw(int money);
}
