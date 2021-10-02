package me.lenglet.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import java.time.Instant;

@Validated
@RestController
public class Controller {

    @Valid
    @Future
    @GetMapping
    public Instant get() {
        return Instant.parse("2021-10-01T11:09:55.812262568Z");
    }
}
