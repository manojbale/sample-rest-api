package com.laks.test.samplerestapi.controller;

import com.laks.test.samplerestapi.repo.AzureRepository;
import com.laks.test.samplerestapi.repo.Todo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@Slf4j
public class RestController {

    final AzureRepository azureRepository;

    @GetMapping("/getData")
    public String getData() {
        List<Todo> all = azureRepository.findAll();
        log.info("data from table - ", all.size());
        if (all.isEmpty()) {
            return "no data found";
        } else return all.toString();

    }

    @GetMapping("/postData/{id}")
    public String postData(@PathVariable String id) {
        Todo todo = new Todo();
        todo.setDescription("hello" + id);
        todo.setDetails("hello" + id);
        todo.setDone("true");

        azureRepository.save(todo);
        log.info("data from table - ", azureRepository.findAll().size());
        return azureRepository.findAll().toString();

    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        log.info("{} of records will be deleted from table", azureRepository.findAll().size());

        azureRepository.deleteAll();
        log.info("all records are deleted from table - ");

    }
}
