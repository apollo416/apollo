package com.github.apollo416.apollo.decision.functions;

import com.github.apollo416.apollo.decision.models.Decision;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.github.apollo416.apollo.decision.DecisionService;

public class CreateDecisionHandler implements RequestHandler<Decision, Decision> {
    public DecisionService service;

    public CreateDecisionHandler(DecisionService service) {
        this.service = service;
    }

    public Decision handler(Decision decision) {
        this.service.CreateDecision(decision);
        return decision;
    }

    @Override
    public Decision handleRequest(Decision input, Context context) {
        return input;
    }
}
