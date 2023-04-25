package com.swm.babzip.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping
    public String onBoarding() {
        return "onBoarding";
    }

    @GetMapping("mypage")
    public String myPage() {
        return "mypage";
    }
}
