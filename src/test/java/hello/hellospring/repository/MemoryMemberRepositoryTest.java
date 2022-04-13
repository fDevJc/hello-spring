package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.*;

import hello.hellospring.domain.Member;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        memberRepository.clear();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member = new Member();
        member.setName("spring");
        memberRepository.save(member);

        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member result = memberRepository.findByName("spring").get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring");
        memberRepository.save(member2);

        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }
}