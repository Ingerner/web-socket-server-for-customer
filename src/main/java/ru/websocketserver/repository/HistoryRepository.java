package ru.websocketserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.websocketserver.domain.entity.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
