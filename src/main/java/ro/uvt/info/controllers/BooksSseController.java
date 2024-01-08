package ro.uvt.info.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.services.AllBooksSubject;
import ro.uvt.info.services.Observer;
import ro.uvt.info.services.SseObserver;

@RestController
public class BooksSseController {


    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @RequestMapping("/books-sse")
    public ResponseBodyEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);
        Observer observer = new SseObserver(emitter);
        allBooksSubject.attach(observer);
        return emitter;
    }
}
