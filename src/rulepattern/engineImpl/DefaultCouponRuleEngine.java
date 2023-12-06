package rulepattern.engineImpl;

import rulepattern.ICouponRuleEngine;
import rulepattern.IRule;
import rulepattern.model.CouponData;

import java.util.ArrayList;
import java.util.List;

public class DefaultCouponRuleEngine implements ICouponRuleEngine {

    private List<IRule> rules;

    public DefaultCouponRuleEngine() {
        rules = new ArrayList<>();
    }

    public void addRule(IRule rule) {
        this.rules.add(rule);
    }

    public void removeRule(IRule rule) {
        this.rules.remove(rule);
    }

    @Override
    public void evaluateRules(CouponData input) {
        System.out.println("rules evaluate started");

        rules.stream()
                .filter(rule -> rule.isRuleApplicable(input))
                .forEach(rule -> rule.applyRule(input));

        System.out.println("rules evaluate completed");
    }
}
