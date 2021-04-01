package com.oodlefinance.alex.megremis.external.api.v1;

import com.oodlefinance.alex.megremis.external.MessagesInternalClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping ("/api/v2/message")
@Slf4j
public class MessageController {

    private final MessagesInternalClient client;

    public MessageController(final MessagesInternalClient client) {
        this.client = client;
        save("Hello world from external startup");
    }

    @PostMapping
    public Integer save(@RequestBody final String message) {
        return client.save(message);
    }
//
//    @GetMapping()
//    public List<MessageDTO> getAllMessages() {
//        return client.getAll();
//    }
//
//    @GetMapping (value = "{id}")
//    @ResponseBody
//    public ResponseEntity getMessage(@PathVariable (name = "id") final Integer id) {
//        ResponseEntity result = client.get(id);
//
//        return result;
//    }
//
//    @DeleteMapping (value = "{id}")
//    public ResponseEntity delete(@PathVariable (name = "id") final Integer id) {
//        ResponseEntity result = client.delete(id);
//
//        return result;
//    }
}
