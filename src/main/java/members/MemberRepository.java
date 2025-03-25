package members;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByNameContaining(String name);
    List<Member> findByPhoneNumberContaining(String phoneNumber);
    List<Member> findByEmailContaining(String email);
}
