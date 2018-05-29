package pl.polsl.rtc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.rtc.entity.Stream;
import pl.polsl.rtc.service.StreamService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StreamController {

    @Autowired
    private StreamService streamService;

    @GetMapping("/streams")
    public ResponseEntity<List<Stream>> getAllStreams() {

    }
}
