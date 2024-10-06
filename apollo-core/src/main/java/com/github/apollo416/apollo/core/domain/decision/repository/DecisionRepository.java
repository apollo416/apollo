package com.github.apollo416.apollo.core.domain.decision.repository;

import com.github.apollo416.apollo.core.domain.decision.model.Decision;

public interface DecisionRepository {
    public Decision GetDecision(String id);
    public void CreateDecision(Decision decision);
    public void UpdateDecision(Decision decision);
}
