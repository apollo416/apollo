package com.github.apollo416.apollo.decision.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.github.apollo416.apollo.decision.DecisionService;
import com.github.apollo416.apollo.decision.models.Decision;

public class GetDecisionHandler implements RequestHandler<Decision, Decision> {
    public DecisionService service;

    public GetDecisionHandler(DecisionService service) {
        this.service = service;
    }

    public Decision handler(Decision decision) {
        this.service.GetDecision();
        return decision;
    }

    @Override
    public Decision handleRequest(Decision input, Context context) {
        return input;
    }
}
