package com.github.apollo416.apollo.decision.functions;

import com.github.apollo416.apollo.core.domain.decision.model.Decision;
import com.github.apollo416.apollo.core.domain.decision.service.DecisionService;
import com.github.apollo416.apollo.core.domain.decision.repository.DecisionRepository;
import com.github.apollo416.apollo.core.domain.decision.memory.InMemoryDecisionRepository;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class CreateDecisionHandler implements RequestHandler<Decision, Decision> {

    private DecisionService decisionService;

    public CreateDecisionHandler() {
        DecisionRepository decisionRepository = new InMemoryDecisionRepository();
        this.decisionService = new DecisionService(decisionRepository);
    }

    @Override
    public Decision handleRequest(Decision input, Context context) {
        this.decisionService.CreateDecision(input);
        return input;
    }
}
