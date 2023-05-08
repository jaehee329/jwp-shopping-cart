package cart.service;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import cart.persistence.dao.MemberDao;
import cart.persistence.entity.Member;
import cart.service.MemberService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "classpath:schema-truncate.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MemberServiceTest {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private MemberService memberService;

    @Test
    void findAll_메서드로_모든_memberEntity를_불러온다() {
        final Member member = new Member("a@a.com", "password1");
        memberDao.save(member);

        final List<Member> members = memberService.findAll();
        final Member foundMember = members.get(0);

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(members.size()).isEqualTo(1);
            softAssertions.assertThat(foundMember.getEmail()).isEqualTo("a@a.com");
            softAssertions.assertThat(foundMember.getPassword()).isEqualTo("password1");
        });
    }
}
