package com.github.apollo416.apollo.core.domain.decision.service;

import com.github.apollo416.apollo.core.domain.decision.model.Decision;
import com.github.apollo416.apollo.core.domain.decision.repository.DecisionRepository;

public class DecisionService {
    private DecisionRepository decisionRepository;

    public DecisionService(DecisionRepository decisionRepository) {
        this.decisionRepository = decisionRepository;
    }

    public Decision GetDecision(String id) {
        return this.decisionRepository.GetDecision(id);
    }

    public void CreateDecision(Decision decision) {
        this.decisionRepository.CreateDecision(decision);
    }

    public void UpdateDecision(Decision decision) {
        this.decisionRepository.UpdateDecision(decision);
    }
}
