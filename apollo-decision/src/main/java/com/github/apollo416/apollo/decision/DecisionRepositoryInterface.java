package com.github.apollo416.apollo.decision;

import com.github.apollo416.apollo.decision.models.Decision;

public interface DecisionRepositoryInterface {
    public Decision GetDecision();
    public void CreateDecision(Decision decision);
    public void UpdateDecision(Decision decision);
}
