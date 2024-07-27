package ru.gen.prtime.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.dto.ReceptionDTO;
import ru.gen.prtime.service.ReceptionService;

import java.util.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/receptions/{receptionId:\\d+}")
public class ReceptionController {

    private final ReceptionService receptionService;

    //ToDo НЕЛЬЗЯ!!!!!!!!!!!!!!!!! ПЕРЕДАВАТЬ ВО ВЬЮ ИЗНАЧАЛЬНЫЙ ОБЪЕКТ ИЗ БАЗЫ!!!!!!!!!!!!!!!! ТОЛЬКО ДТО

    @GetMapping
    public Reception getReception(@PathVariable("receptionId") Integer receptionId) {
        return receptionService.findReception(receptionId).orElseThrow(() -> new NoSuchElementException("Встреча не найдена"));
    }

    @PatchMapping
    public void editReception(@PathVariable("receptionId") Integer receptionId,
                              @RequestBody ReceptionDTO editReception) {
        receptionService.editReception(receptionId, editReception);
    }

    @DeleteMapping
    public void removeReception(@PathVariable("receptionId") Integer receptionId) {
        receptionService.removeReception(receptionId);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<NoSuchElementException> handleNoSuchElementException(NoSuchElementException exception) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}