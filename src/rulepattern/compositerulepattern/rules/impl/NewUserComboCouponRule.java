package rulepattern.compositerulepattern.rules.impl;

import rulepattern.compositerulepattern.rules.ApplyRule;
import rulepattern.compositerulepattern.rules.IEvaluateRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;

import java.util.ArrayList;

import static rulepattern.compositerulepattern.util.RuleUtils.and;
import static rulepattern.compositerulepattern.util.RuleUtils.or;

public class NewUserComboCouponRule extends ApplyRule<CouponData, Void> {

    public NewUserComboCouponRule() {
    }

    @Override
    public boolean isRuleApplicable(CouponData input) {
        IEvaluateRule newUserRule = new NewUserCouponRule();
        IEvaluateRule festiveRule = new FestivalOfferCouponRule();
        IEvaluateRule birthDayRule = new BirthDaySpecialCouponRule();

        return and(newUserRule, or(festiveRule, birthDayRule)).isRuleApplicable(input);
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }

        input.getCoupons().add(Coupon.NEW_USER_COMBO_OFFER);

        System.out.println("Added NEW_USER_COMBO_OFFER coupon");
        return null;
    }
}
