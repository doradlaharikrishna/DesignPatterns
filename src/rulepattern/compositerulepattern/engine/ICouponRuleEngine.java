package rulepattern.compositerulepattern.engine;

import rulepattern.compositerulepattern.rules.ApplyRule;
import rulepattern.model.CouponData;

public interface ICouponRuleEngine {

    void addRule(ApplyRule rule);

    void removeRule(ApplyRule rule);

    void evaluateRules(CouponData input);
}
