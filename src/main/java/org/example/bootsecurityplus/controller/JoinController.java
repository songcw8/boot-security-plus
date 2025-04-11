package org.example.bootsecurityplus.controller;

import lombok.RequiredArgsConstructor;
import org.example.bootsecurityplus.model.domain.SecurityUser;
import org.example.bootsecurityplus.model.mapper.SecurityUserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/join")
public class JoinController {
    private final SecurityUserMapper securityUserMapper;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String joinForm() {
        return "join";
    }

    @PostMapping
    public String joinUser(@RequestParam String username, @RequestParam String password, Model model) {
        // 이미 중복 가입인지 확인
        SecurityUser existingUser = securityUserMapper.findByUsername(username);
        if (existingUser != null) {
            model.addAttribute("error", "이미 존재하는 사용자입니다.");
            return "join";
        }
        // 생성하면 된다
        String encodedPassword = passwordEncoder.encode(password);
        SecurityUser newUser = SecurityUser.toDB(username, encodedPassword, "USER");
        securityUserMapper.insertUser(newUser);
        return "redirect:/login";
    }

}
