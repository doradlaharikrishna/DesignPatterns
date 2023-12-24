package rulepattern;

public interface IRule<I, O> {

    boolean isRuleApplicable(I input);

    O applyRule(I input);
}
