package members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }


    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }


    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }


    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }


    @GetMapping("/search")
    public List<Member> searchMember(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String phoneNumber) {
        if (name != null) {
            return memberService.searchByName(name);
        } else if (phoneNumber != null) {
            return memberService.searchByPhoneNumber(phoneNumber);
        }
        return null;
    }
}
