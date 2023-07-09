package hello.advanced;

import hello.advanced.trace.FieldLogTrace;
import hello.advanced.trace.ThreadLocalLogTrace;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {


    // Configuration 어노테이션은 내부에 @Component가 선언되어 있어
    // ComponentScan의 대상이 된다.
    // 그러므로 LogTrace를 스프링 Bean으로 등록 된다 -> 싱글톤
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
