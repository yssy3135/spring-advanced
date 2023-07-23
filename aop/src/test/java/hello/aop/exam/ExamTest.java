package hello.aop.exam;

import hello.aop.exam.aop.RetryAspect;
import hello.aop.exam.aop.TraceAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Slf4j
@Import(TraceAspect.class)
public class ExamTest {


    @Autowired
    ExampleService exampleService;


    @Test
    void test() {
        for(int i = 0 ;i  < 5 ; i++) {
            log.info("client request i={}", i);
            exampleService.request("data" + i);
        }
    }
}
