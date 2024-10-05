package com.github.apollo416.apollo.decision;

import com.github.apollo416.apollo.decision.models.Decision;

public class DecisionService {

    private DecisionRepositoryInterface repository;

    public DecisionService(DecisionRepositoryInterface repository) {
        this.repository = repository;
    }

    public Decision GetDecision() {
        return this.repository.GetDecision();
    }

    public void CreateDecision(Decision decision) {
        this.repository.CreateDecision(decision);
    }

    public void UpdateDecision(Decision decision) {
        this.repository.UpdateDecision(decision);
    }
}
