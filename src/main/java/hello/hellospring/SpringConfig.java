package hello.hellospring;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    // Spring Bean에 MemberService, MemberRepository 올리고,
    // MemberService Bean에 올라온 MemberRepository를 사용하도록 함

    @Autowired
    DataSource dataSource;

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    // 가장 중요! 다형성
    @Bean
    MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
