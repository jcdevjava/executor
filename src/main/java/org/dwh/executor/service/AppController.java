package org.dwh.executor.service;

import org.dwh.executor.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    @RequestMapping("/ping")
    public ResponseEntity<MessageResponse> ping() {
        return ResponseEntity.ok(MessageResponse.ok("pong"));
    }


}
