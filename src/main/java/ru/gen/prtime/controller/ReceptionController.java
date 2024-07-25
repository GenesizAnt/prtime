package ru.gen.prtime.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.dto.ReceptionDTO;
import ru.gen.prtime.service.ReceptionService;

import java.util.List;
import java.util.NoSuchElementException;
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
    public ResponseEntity<Stream<String>> createReception(@RequestBody @Valid ReceptionDTO receptionDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            List<String> list = bindingResult.getAllErrors()
                    .stream()
                    .map(objectError -> "Ваше сообщение об ошибке: " + objectError.getDefaultMessage()).toList();
            Stream<String> stream = list.stream();

            return new ResponseEntity<>(Stream.generate(() -> "А какого хрена?"),
                    HttpStatus.NOT_FOUND);


//            return new ResponseEntity<>(
//                    bindingResult.getAllErrors()
//                            .stream()
//                            .map(ObjectError::getDefaultMessage), HttpStatus.NOT_FOUND);
        } else {
            receptionService.save(receptionDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
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
}

class AppError {
    private int statusCode;
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AppError() {
    }

    public AppError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}