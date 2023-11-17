package by.javaguru.listener;

import org.springframework.context.ApplicationEvent;

public class EntityEvent extends ApplicationEvent {
    private final AccessType accessType;
    private boolean isHappened;

    public EntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }

    public EntityEvent(Object source, AccessType accessType, boolean isHappened) {
        super(source);
        this.accessType = accessType;
        this.isHappened = isHappened;
    }

    public AccessType getAcceptType() {
        return accessType;
    }

    public boolean isHappened() {
        return isHappened;
    }
}
