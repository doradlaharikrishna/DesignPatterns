package rulepattern.compositerulepattern.rules.impl;

import rulepattern.compositerulepattern.rules.IEvaluateRule;
import rulepattern.model.CouponData;
import rulepattern.model.User;

import java.time.LocalDate;

public class BirthDaySpecialCouponRule implements IEvaluateRule<CouponData> {

    public BirthDaySpecialCouponRule() {
    }

    @Override
    public boolean isRuleApplicable(CouponData input) {
        final User user = input.getUser();

        LocalDate todayDate = LocalDate.now();
        LocalDate userBirthDay = user.getDateOfBirth();

        return todayDate.equals(userBirthDay);
    }
}
