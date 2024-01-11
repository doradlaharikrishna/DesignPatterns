package rulepattern.compositerulepattern.rules;

public interface IEvaluateRule<I> {

    boolean isRuleApplicable(I input);
}
