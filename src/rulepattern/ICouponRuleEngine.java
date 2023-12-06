package rulepattern;

import rulepattern.model.CouponData;

public interface ICouponRuleEngine {

    void addRule(IRule rule);

    void removeRule(IRule rule);

    void evaluateRules(CouponData input);
}
