package ru.gen.prtime.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.dto.ReceptionDTO;
import ru.gen.prtime.service.ReceptionService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin(origins = "${cors.frontend}")
@RestController
@RequiredArgsConstructor
@RequestMapping("schedule/receptions")
public class ReceptionController {

    private final ReceptionService receptionService;

    @GetMapping("/list")
    public List<Reception> getReceptionList() {
        return receptionService.findAllReceptions();
    }

    @PostMapping("/create")
    public void createReception(@RequestBody @Valid ReceptionDTO receptionDTO) {
        receptionService.save(receptionDTO);
    }

    @GetMapping("{receptionId:\\d+}")
    public Reception getReception(@PathVariable("receptionId") Integer receptionId) {
        return receptionService.findReception(receptionId).orElseThrow(() -> new NoSuchElementException("Встреча не найдена"));
    }

    @PatchMapping("/edit")
    public void editReception(@RequestBody ReceptionDTO editReception) {
        receptionService.editReception(editReception);
    }

    @DeleteMapping("{receptionId:\\d+}")
    public void removeReception(@PathVariable("receptionId") Integer receptionId) {
        receptionService.removeReception(receptionId);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<NoSuchElementException> handleNoSuchElementException(NoSuchElementException exception) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(ex.getBindingResult().getAllErrors()
                .stream().map(ObjectError::getDefaultMessage)
                .toList(), HttpStatus.BAD_REQUEST);
    }
}