package com.amalvadkar.sdjia.project.services;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SpringDebugger {

    private final EntityManager em;

    public PersistenceContext persistenceContext(){
        SessionImplementor session = session();
        return session.getPersistenceContext();
    }

    private SessionImplementor session() {
        return em.unwrap(SessionImplementor.class);
    }

    public Map<EntityKey, Object> entitiesFromPC(){
        PersistenceContext pc = persistenceContext();
        return pc.getEntitiesByKey();
    }

    public Map<String, Object> transactionDetails(){
        Map<String, Object> map = new HashMap<>();

        map.put("Transaction Name", TransactionSynchronizationManager.getCurrentTransactionName());
        map.put("Isolation Level", TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());
        map.put("Read-only", TransactionSynchronizationManager.isCurrentTransactionReadOnly());
        map.put("Synchronization Active", TransactionSynchronizationManager.isSynchronizationActive());
        map.put("Actual Transaction Active", TransactionSynchronizationManager.isActualTransactionActive());

        return map;

    }

}
