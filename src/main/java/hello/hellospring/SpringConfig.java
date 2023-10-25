package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // Spring Bean에 MemberService, MemberRepository 올리고,
    // MemberService Bean에 올라온 MemberRepository를 사용하도록 함
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
