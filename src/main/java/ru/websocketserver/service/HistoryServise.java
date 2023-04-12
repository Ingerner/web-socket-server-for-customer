package ru.websocketserver.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.websocketserver.domain.entity.History;
import ru.websocketserver.domain.message.outgoing.HistoryOutgoing;
import ru.websocketserver.repository.HistoryRepository;

@Service
@RequiredArgsConstructor
public class HistoryServise {
    private final HistoryRepository repositoryHistory;
    public History saveHistory(@NonNull HistoryOutgoing dataHistoryOutgoing) {
        final History dataHistory = History.builder()
                .messageId(dataHistoryOutgoing.getMessageId())
                .messageText(dataHistoryOutgoing.getMessageText())
                .build();
        return repositoryHistory.save(dataHistory);
    }
}
