package ru.gen.prtime.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.dto.ReceptionDTO;
import ru.gen.prtime.service.ReceptionService;

import java.util.List;
import java.util.NoSuchElementException;

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
    public void createReception(@RequestBody ReceptionDTO receptionDTO) {
        receptionService.save(receptionDTO);
    }

    @GetMapping("{receptionId:\\d+}")
    public Reception getReception(@PathVariable("receptionId") Integer receptionId) {
        return receptionService.findReception(receptionId).orElseThrow();
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
