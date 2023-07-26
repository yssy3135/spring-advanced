package hello.aop.exam.aop.proxyvs;

import hello.aop.exam.aop.proxyvs.code.ProxyDIAspect;
import hello.aop.member.MemberService;
import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"})  // JDK 동적 프록시 OK , CGLIB OK
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=false"})  // JDK 동적 프록시 X , CGLIB OK, 주입되길 기대하는 타입이 아닌 프록시 객체가 주입되기 때문에 타입 예외가 발생한다.
@SpringBootTest
@Import(ProxyDIAspect.class)
public class ProxyDITest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberServiceImpl memberServiceImpl;


    @Test
    void go() {
        log.info("memberService class={}", memberService.getClass() );
        log.info("memberServiceImpl class={}", memberServiceImpl.getClass());
        memberServiceImpl.hello("hello");
    }


}
