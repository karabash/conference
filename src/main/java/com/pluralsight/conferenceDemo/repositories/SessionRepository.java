package com.pluralsight.conferenceDemo.repositories;

import com.pluralsight.conferenceDemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository  extends JpaRepository<Session, Long> {
}
