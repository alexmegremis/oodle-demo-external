package com.oodlefinance.alex.megremis.external;

import com.oodlefinance.alex.megremis.external.api.v1.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "Internal-API", decode404 = true)
@RequestMapping(value = "/api/v1")
public interface MessagesInternalClient {
    @GetMapping("/message")
    List<MessageDTO> getAll();

    @GetMapping("/message/{id}")
    MessageDTO get(@PathVariable("id") final Integer id);

    @PostMapping("/message")
    Integer save(@RequestBody final String message);

    @DeleteMapping (value = "/message/{id}")
    void delete(@PathVariable (name = "id") final Integer id);
}
