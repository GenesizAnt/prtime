package ru.gen.prtime.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gen.prtime.dto.ReceptionDTO;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.service.ReceptionService;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/receptions")
public class ReceptionsController {

    private final ReceptionService receptionService;
    private final MessageSource messageSource;

    @GetMapping("/list")
    public List<Reception> getAllReception() {
        return receptionService.findAllReceptions();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createReception(@Valid @RequestBody ReceptionDTO receptionDTO,
                                             BindingResult bindingResult, Locale locale) {
        if (bindingResult.hasErrors()) {
            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                    HttpStatus.BAD_REQUEST,
                    messageSource.getMessage("errors.400.title", new Object[0], "errors.400.title", locale));
            problemDetail.setProperty("errors", bindingResult
                    .getAllErrors()
                    .stream()
                    .map(MessageSourceResolvable::getDefaultMessage)
                    .filter(Objects::nonNull)
                    .toList());
            return ResponseEntity.badRequest().body(problemDetail);
        } else {
            Reception reception = receptionService.save(receptionDTO);
            return ResponseEntity.ok(reception);
        }
    }
}
