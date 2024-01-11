package rulepattern.compositerulepattern.compositerules;

import rulepattern.compositerulepattern.rules.IEvaluateRule;

import java.util.List;

public class AndRule<I> implements IEvaluateRule<I> {
    private final List<IEvaluateRule<I>> rules;

    public AndRule(List<IEvaluateRule<I>> rules) {
        this.rules = rules;
    }

    @Override
    public boolean isRuleApplicable(I input) {
        for (IEvaluateRule<I> rule : rules) {
            if (!rule.isRuleApplicable(input)) {
                return false;
            }
        }

        return true;
    }
}
