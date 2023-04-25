package com.swm.babzip.domain.party;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("parties")
@RequiredArgsConstructor
public class PartyController {
    private final PartyService partyService;

    @GetMapping
    public String partyList(Model model) {
        model.addAttribute("parties", partyService.findAll());
        return "party-list";
    }

    @GetMapping("form")
    public String partyForm() {
        return "party-make";
    }

    @GetMapping("{id}")
    public String partyDetail(@PathVariable Long id, Model model) {
        model.addAttribute("party", partyService.findById(id));

        return "party-detail";
    }


    @PostMapping
    public String create(@RequestBody final PartyRequest dto) {
        partyService.create(dto);
        return "redirect:/parties";
    }
}
