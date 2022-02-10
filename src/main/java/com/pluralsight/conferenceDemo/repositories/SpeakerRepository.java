package com.pluralsight.conferenceDemo.repositories;

import com.pluralsight.conferenceDemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
