package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링을 사용하지않는 순수한 DI컨테이너 생성")
    void pureContainer() {

        // DI 설정 호출!
        AppConfig appConfig = new AppConfig();

        // 유저-A 접속 가정 객체 생성 1.
        MemberService memberService1 = appConfig.memberService();

        // 유저-B 접속 가정 객체 생성 2.
        MemberService memberService2 = appConfig.memberService();

        // 객체1과 객체2의 메모리 주소값이 동일 한지 확인한다 당연히 다른 객체라서 다르게 나온다.
        System.out.printf("memberService1" + memberService1);
        System.out.printf("memberService2" + memberService2);

        // 테스트 유닛으로 한번 더 검증한다.
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 사용한 객체 사용")
    void SingletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        System.out.print("singletonService1 = " + singletonService1);
        System.out.print("singletonService2 = " + singletonService2);
        assertThat(singletonService1).isSameAs(singletonService2);
    }
}
