package rulepattern.compositerulepattern.rules.impl;

import rulepattern.compositerulepattern.rules.IEvaluateRule;
import rulepattern.model.CouponData;
import rulepattern.model.User;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NewUserCouponRule implements IEvaluateRule<CouponData> {

    public NewUserCouponRule() {
    }

    @Override
    public boolean isRuleApplicable(CouponData input) {
        final User user = input.getUser();

        LocalDateTime presentDate = LocalDateTime.now();
        LocalDateTime userAccountCreated = user.getCreatedAt();

        long daysBetween = ChronoUnit.DAYS.between(presentDate, userAccountCreated);

        return daysBetween <= 7;
    }
}
