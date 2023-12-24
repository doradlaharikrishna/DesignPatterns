package rulepattern.ruleImpl;

import rulepattern.IRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;
import rulepattern.model.User;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class NewUserCouponRule implements IRule<CouponData, Void> {

    public NewUserCouponRule() {
        System.out.println("Adding NewUserCouponRule");
    }

    @Override
    public boolean isRuleApplicable(CouponData input) {
        final User user = input.getUser();

        LocalDateTime presentDate = LocalDateTime.now();
        LocalDateTime userAccountCreated = user.getCreatedAt();

        long daysBetween = ChronoUnit.DAYS.between(presentDate, userAccountCreated);

        final boolean result = daysBetween <= 7;

        System.out.println(String.format("Result of NewUserCouponRule evaluation is: %s", result));

        return result;
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }

        input.getCoupons().add(Coupon.NEW_USER);
        System.out.println("Added NEW_USER coupon");
        return null;
    }
}
