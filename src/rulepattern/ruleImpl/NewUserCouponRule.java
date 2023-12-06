package rulepattern.ruleImpl;

import rulepattern.IRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;
import rulepattern.model.User;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class NewUserCouponRule implements IRule<CouponData, Void> {

    @Override
    public boolean isRuleApplicable(CouponData input) {
        final User user = input.getUser();

        LocalDateTime presentDate = LocalDateTime.now();
        LocalDateTime userAccountCreated = user.getCreatedAt();

        long daysBetween = ChronoUnit.DAYS.between(presentDate, userAccountCreated);

        return daysBetween <= 7;
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }

        input.getCoupons().add(Coupon.NEW_USER);

        return null;
    }
}
