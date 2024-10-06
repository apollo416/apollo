package com.github.apollo416.apollo.core.domain.decision.memory;

import java.util.Map;
import java.util.HashMap;
import com.github.apollo416.apollo.core.domain.decision.model.Decision;
import com.github.apollo416.apollo.core.domain.decision.repository.DecisionRepository;

public class InMemoryDecisionRepository implements DecisionRepository{
    public Map<String, Decision> decisions = new HashMap<>();

    @Override
    public Decision GetDecision(String id) {
        Decision decision = decisions.get(id);
        return decision;
    }

    @Override
    public void CreateDecision(Decision decision) {
        decisions.put(decision.id, decision);
    }

    @Override
    public void UpdateDecision(Decision decision) {
        decisions.put(decision.id, decision);
    }
}
