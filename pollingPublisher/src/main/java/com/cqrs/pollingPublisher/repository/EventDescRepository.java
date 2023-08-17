package com.cqrs.pollingPublisher.repository;

import com.cqrs.pollingPublisher.domain.EventDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EventDescRepository extends JpaRepository<EventDesc, Long> {
    List<EventDesc> findByStatus(EventDesc.Status status);

    @Modifying
    @Query("update EventDesc e set e.status= :status where e.id in :eventIds")
    void markAsPublished(@Param("eventIds") List<UUID> eventIds, @Param("status") EventDesc.Status status);
}
