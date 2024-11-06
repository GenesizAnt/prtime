package ru.gen.prtime.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gen.prtime.dto.ReceptionDTO;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.service.ReceptionService;

import java.util.List;

@CrossOrigin(origins = "${cors.frontend}")
@RestController
@RequiredArgsConstructor
@RequestMapping("/receptions")
public class ReceptionsController {

    private final ReceptionService receptionService;

    @GetMapping
    public List<Reception> getAllReception(@RequestParam(name = "filter", required = false) String filter) {
        return receptionService.findAllReceptions(filter);
    }

    @PostMapping
    public ResponseEntity<?> createReception(@Valid @RequestBody ReceptionDTO receptionDTO,
                                             BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            Reception reception = receptionService.save(receptionDTO);
            return ResponseEntity.ok(reception);
        }
    }
}
