package com.oodlefinance.alex.megremis.external;

import com.oodlefinance.alex.megremis.external.api.v1.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "Internal-API")
@RequestMapping(value = "/api/v1/message")
public interface MessagesInternalClient {
    @GetMapping
    List<MessageDTO> getAll();

    @GetMapping(value = "{id}")
    ResponseEntity<MessageDTO> get(@PathVariable("id") final Integer id);

    @PostMapping
    Integer save(@RequestBody final String message);

    @DeleteMapping (value = "{id}")
    ResponseEntity delete(@PathVariable (name = "id") final Integer id);
}
