package com.pluralsight.conferenceDemo.controllers;

import com.pluralsight.conferenceDemo.models.Session;
import com.pluralsight.conferenceDemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    //gives CRUD access and other access to our sessions database table and data
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list() {
        //returns  all sessions, if you call it, that use rhe GET HTTP verb.
        return sessionRepository.findAll();
    }

    //returns specific sessions
    // looking for particular session which will pass
    //url to our parameter @pathvariable long  id
    //which we can then pass to the SessionRepository
    //and that will return our session
    //which will be returned to have a JSON marshalled.
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
         //Also need to check for children records before deleting
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        //TODO: add validation that all attributes are passed in, otherwise return 400 bad payload
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }
}

 