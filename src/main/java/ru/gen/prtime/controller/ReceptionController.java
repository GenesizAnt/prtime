package ru.gen.prtime.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.service.ReceptionService;

import java.util.List;

@CrossOrigin(origins = "${cors.frontend}")
@RestController
@RequiredArgsConstructor
@RequestMapping("schedule/receptions")
public class ReceptionController {

    private final ReceptionService receptionService;

    @GetMapping
    public List<Reception> getReceptionList() {
        return receptionService.findAllReceptions();
    }
}
