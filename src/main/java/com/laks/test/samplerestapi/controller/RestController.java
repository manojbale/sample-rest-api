package com.laks.test.samplerestapi.controller;

import com.laks.test.samplerestapi.repo.AzureRepository;
import com.laks.test.samplerestapi.repo.Todo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@Slf4j
public class RestController {

    final AzureRepository azureRepository;

    @GetMapping("/getData")
    public String getData() {
        log.info("data from table - ", azureRepository.findAll().get(0));
        return azureRepository.findAll().toString();
//        return "index";
    }

    @GetMapping("/postData/{id}")
    public String postData(@PathVariable int id) {
        Todo todo = new Todo();
        todo.setId(Long.valueOf(id));
        todo.setDescription("hello");
        todo.setDetails("hello");
        todo.setDone(true);

        azureRepository.save(todo);
        log.info("data from table - ", azureRepository.findAll().size());
        return azureRepository.findAll().toString();
//        return "index";
    }
}
