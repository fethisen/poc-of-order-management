package com.fethi.productsalesteamA.eventstore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventDesc, Long> {
}
