package com.vaultforge.mongo;

import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("activity_events")
public class ActivityEvent {

    @Id
    private String id;

    private String type;
    private String message;
    private Instant createdAt;

    protected ActivityEvent() {}

    public ActivityEvent(String type, String message) {
        this.type = type;
        this.message = message;
        this.createdAt = Instant.now();
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public String getMessage() { return message; }
    public Instant getCreatedAt() { return createdAt; }
}