package com.wanted_server.Controller;

import com.wanted_server.Class.Personal;
import com.wanted_server.Dto.PersonalDto;
import com.wanted_server.Repository.PersonalRepository;
import com.wanted_server.Service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HomeController {
    private final PersonalRepository personalRepository;
    private final PersonalService personalService;

    @GetMapping("/personal")
    public List<Personal> getPersonal() {
        return personalRepository.findAll();
    }

    @PostMapping("/personal")
    public Personal createPersonal(@RequestBody PersonalDto personalDto) {
        Personal personal = new Personal(personalDto);
        personalService.join(personal);
        return personal;
    }

    @PutMapping("/personal/{mem_num}")
    public Long updatePersonal(@PathVariable Long personalId, @RequestBody PersonalDto personalDto) {
        return personalService.update(personalId, personalDto);
    }

    @DeleteMapping("/personal/{mem_num}")
    public Long deletePersonal(@PathVariable Long personalId) {
        personalService.deleteById(personalId);
        return personalId;
    }
}
