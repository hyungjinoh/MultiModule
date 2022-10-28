package dev.be.moduleapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.response.CodeEnum;
import dev.be.modulecommon.repositories.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DemoService {

    @Value("${profile-name}")
    private String name;

    private final MemberRepository memberRepository;

    private final CommonDemoService commonDemoService;

    public String save() {
        System.out.println("env profile : " + name);
        System.out.println("commonDemoService.getName() : " + commonDemoService.getModuleName());

        //DB에 저장할때엔 엔터티 객체를 빌더형식으로 생성후 저장한다.
        Member newMember = memberRepository.save(Member.builder()
                                                       .name(Thread.currentThread().getName())
                                                       .build());
        return newMember.getName();
    }

    public String find() {
        //String으로 리턴해야 해서...다음과 같이 표시함???ㄴ        return String.valueOf(memberRepository.findAll().size());
    }

    public String handleCustomException() {
        if (true) {
            System.out.println("Throw CustomException");
            throw new CustomException(CodeEnum.NOT_IDENTITY_VERIFIED_USER);
        }

        return "exception";
    }
}
