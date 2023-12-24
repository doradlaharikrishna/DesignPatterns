package rulepattern.ruleImpl;

import rulepattern.IRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;
import rulepattern.model.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class BirthDaySpecialCouponRule implements IRule<CouponData, Void> {

    public BirthDaySpecialCouponRule() {
        System.out.println("Adding BirthDaySpecialCouponRule");
    }

    @Override
    public boolean isRuleApplicable(CouponData input) {
        final User user = input.getUser();

        LocalDate todayDate = LocalDate.now();
        LocalDate userBirthDay = user.getDateOfBirth();

        final boolean result = todayDate.equals(userBirthDay);

        System.out.println(String.format("Result of BirthDaySpecialCouponRule evaluation is: %s", result));

        return result;
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }

        input.getCoupons().add(Coupon.BIRTHDAY_SPECIAL);

        System.out.println("Added BIRTHDAY_SPECIAL coupon");
        return null;
    }
}
