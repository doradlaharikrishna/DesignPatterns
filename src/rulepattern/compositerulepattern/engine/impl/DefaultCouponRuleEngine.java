package rulepattern.compositerulepattern.engine.impl;

import rulepattern.compositerulepattern.rules.ApplyRule;
import rulepattern.compositerulepattern.engine.ICouponRuleEngine;
import rulepattern.model.CouponData;

import java.util.ArrayList;
import java.util.List;

public class DefaultCouponRuleEngine implements ICouponRuleEngine {

    private List<ApplyRule> rules;

    public DefaultCouponRuleEngine() {
        rules = new ArrayList<>();
    }

    public void addRule(ApplyRule rule) {
        this.rules.add(rule);
    }

    public void removeRule(ApplyRule rule) {
        this.rules.remove(rule);
    }

    @Override
    public void evaluateRules(CouponData input) {
        rules.forEach(rule -> {
            if (rule.isRuleApplicable(input)) {
                rule.applyRule(input);
            }
        });
    }
}
