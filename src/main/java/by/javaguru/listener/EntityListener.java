package by.javaguru.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {

    @EventListener(condition = "#root.args[0].acceptType.name() == 'READ'")
    public void acceptEntityRead(EntityEvent entityEvent) {
        String isHappenedWord = entityEvent.isHappened() ? "after" : "before";
        System.out.printf("Event %s query with type %s was published. Entity: %s \n",
                isHappenedWord, entityEvent.getAcceptType(), entityEvent.getSource());
    }
}
