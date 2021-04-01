package com.oodlefinance.alex.megremis.external.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping ("/api/v1/message")
public class MessageController {

    private             Integer          index             = 0;
    private final       List<MessageDTO> messages          = new ArrayList<>();
    public static final String           NOT_FOUND         = "NOT FOUND";
    public static final String           SUCCESS           = "SUCCESS";
    public static final MessageDTO       MESSAGE_NOT_FOUND = MessageDTO.builder().message(NOT_FOUND).build();

    public MessageController() {
        doSaveMessage("Hello world!");
    }

    @PostMapping
    public Integer saveMessage(@RequestBody final String message) {
        return doSaveMessage(message);
    }

    private Integer doSaveMessage(final String message) {
        index++;
        messages.add(MessageDTO.builder().id(index).message(message).build());

        return index;
    }

    @GetMapping
    public List<MessageDTO> getAllMessages() {
        return messages;
    }

    @GetMapping (value = "{id}")
    @ResponseBody
    public ResponseEntity getMessage(@PathVariable (name = "id") final Integer id) {
        ResponseEntity result = null;

        Optional<MessageDTO> found = messages.stream().filter(m -> m.id == id).findAny();

        if (found.isPresent()) {
            result = ResponseEntity.ok(found.get());
        } else {
            result = ResponseEntity.notFound().build();
        }

        return result;
    }

    @DeleteMapping (value = "{id}")
    public String delete(@PathVariable (name = "id") final Integer id) {
        String result = null;

        Optional<MessageDTO> target = messages.stream().filter(m -> m.id == id).findAny();
        if (target.isPresent()) {
            result = SUCCESS;
            synchronized (messages) {
                messages.remove(target.get());
            }
        } else {
            result = NOT_FOUND;
        }

        return result;
    }
}
