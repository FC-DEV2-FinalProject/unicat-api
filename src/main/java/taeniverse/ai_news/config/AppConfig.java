package taeniverse.ai_news.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .connectTimeout(Duration.ofSeconds(10)) // 서버 연결 타임아웃: 10초
                .readTimeout(Duration.ofSeconds(30)) // 응답 대기 타임아웃: 30초
                .build();    }
}
