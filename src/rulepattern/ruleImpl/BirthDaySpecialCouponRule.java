package rulepattern.ruleImpl;

import rulepattern.IRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;
import rulepattern.model.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class BirthDaySpecialCouponRule implements IRule<CouponData, Void> {

    @Override
    public boolean isRuleApplicable(CouponData input) {
        final User user = input.getUser();

        LocalDate todayDate = LocalDate.now();
        LocalDate userBirthDay = user.getDateOfBirth();

        return todayDate.equals(userBirthDay);
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }

        input.getCoupons().add(Coupon.BIRTHDAY_SPECIAL);

        return null;
    }
}
