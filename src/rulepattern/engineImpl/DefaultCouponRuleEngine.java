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
        rules.forEach(rule -> {
            if (rule.isRuleApplicable(input)) {
                rule.applyRule(input);
            }
        });
    }
}
