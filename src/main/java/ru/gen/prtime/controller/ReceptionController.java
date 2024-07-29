package ru.gen.prtime.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.dto.ReceptionDTO;
import ru.gen.prtime.service.ReceptionService;

import java.util.*;

@CrossOrigin(origins = "${cors.frontend}")
@RestController
@RequiredArgsConstructor
@RequestMapping("/receptions/{receptionId:\\d+}")
public class ReceptionController {

    private final ReceptionService receptionService;
    private final MessageSource messageSource;

    //ToDo НЕЛЬЗЯ!!!!!!!!!!!!!!!!! ПЕРЕДАВАТЬ ВО ВЬЮ ИЗНАЧАЛЬНЫЙ ОБЪЕКТ ИЗ БАЗЫ!!!!!!!!!!!!!!!! ТОЛЬКО ДТО

    @ModelAttribute("reception")
    public Reception getReception(@PathVariable("receptionId") int receptionId) {
        return receptionService.findReception(receptionId)
                .orElseThrow(() -> new NoSuchElementException("errors.reception.not_found"));
    }

    @GetMapping
    public ResponseEntity<Reception> findReception(@ModelAttribute("reception") Reception reception) {
        return ResponseEntity.ok(reception);
    }

    // Поскольку есть @ModelAttribute("reception"), то не нужно проверять на наличие редактируемой Reception
    @PatchMapping
    public ResponseEntity<?> updateReception(@PathVariable("receptionId") int receptionId,
                                             @RequestBody ReceptionDTO editReception,
                                             BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            receptionService.editReception(receptionId, editReception);
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> removeReception(@PathVariable("receptionId") int receptionId) {
        receptionService.deleteReception(receptionId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ProblemDetail> handleNoSuchElementException(NoSuchElementException exception, Locale locale) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                        this.messageSource.getMessage(exception.getMessage(), new Object[0], exception.getMessage(), locale)));
    }
}