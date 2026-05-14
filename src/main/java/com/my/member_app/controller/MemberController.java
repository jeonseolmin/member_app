package com.my.member_app.controller;
import com.my.member_app.dto.MemberDto;
import com.my.member_app.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/view")
    public String list(Model model){
        model.addAttribute("title","회원정보");
        model.addAttribute("lists",memberService.findAll());
        return "showMember";
    }

    @GetMapping("/insertForm")
    public String insertForm(Model model){
        model.addAttribute("memberDto",new MemberDto());
        return "insertMember";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute MemberDto dto,
                         RedirectAttributes redirectAttributes){
        memberService.save(dto);
        redirectAttributes.addFlashAttribute("message","등록이 완료됐습니다.");
        return "redirect:/member/view";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam Long updateId,
                             Model model,
                             RedirectAttributes redirectAttributes){
        MemberDto dto = memberService.findById(updateId);
        if(dto == null){
            redirectAttributes.addFlashAttribute("massage","등록된 회원을 찾을 수 없습니다.");
            return "redirect:/member/view";
        }

        model.addAttribute("member",dto);
        return "updateMember";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MemberDto dto,
                         RedirectAttributes redirectAttributes){
        memberService.save(dto);
        redirectAttributes.addFlashAttribute("message","수정이 완료됐습니다.");
        return "redirect:/member/view";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long deleteId,
                         RedirectAttributes redirectAttributes){
        memberService.deleteById(deleteId);
        redirectAttributes.addFlashAttribute("massage","등록된 회원을 삭제했습니다.");
        return "redirect:/member/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String type,
                         @RequestParam String keyword,
                         Model model)
    {
        model.addAttribute("title", "검색 결과");
        model.addAttribute("lists",memberService.search(type,keyword));
        return "showMember";
    }
}
