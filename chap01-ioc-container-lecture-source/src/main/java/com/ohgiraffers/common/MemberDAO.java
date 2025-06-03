package com.ohgiraffers.common;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/*
 * @Component
 * - 해당 클래스를 스프링의 Bean으로 자동 등록시켜주는 어노테이션이다.
 * - @ComponentScan이 설정된 경로에 위치해야 인식된다.
 * - Bean의 이름은 기본적으로 클래스 이름을 camelCase로 변환한 형태 ("memberDAO")로 등록된다.
 */
@Component
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap;

    /*
     * 기본 생성자에서 테스트용 회원 데이터를 초기화한다.
     */
    public MemberDAO() {
        memberMap = new HashMap<>();

        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    /*
     * 전달받은 sequence(ID)를 기준으로 회원 정보를 조회한다.
     */
    public MemberDTO selectMember(int sequence) {
        return memberMap.get(sequence);
    }

    /*
     * 새로운 회원 정보를 등록한다.
     * 기존 데이터 크기와 비교하여 정상적으로 추가되었는지 여부를 반환한다.
     */
    public boolean insertMember(MemberDTO newMember) {
        int before = memberMap.size();

        memberMap.put(newMember.getSequence(), newMember);
        int after = memberMap.size();

        return after > before;
    }

}
