package com.github.apollo416.apollo.core.domain.decision.service;

import com.github.apollo416.apollo.core.domain.decision.model.Decision;

public interface DecisionService {
    public Decision GetDecision();
    public void CreateDecision(Decision decision);
    public void UpdateDecision(Decision decision);
}
