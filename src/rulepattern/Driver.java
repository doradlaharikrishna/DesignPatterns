package rulepattern;

import rulepattern.engineImpl.DefaultCouponRuleEngine;
import rulepattern.model.CouponData;
import rulepattern.model.User;
import rulepattern.ruleImpl.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Driver {

    public static void main(String args[]) {
        ICouponRuleEngine couponRuleEngine = new DefaultCouponRuleEngine();
        System.out.println("Adding rules to coupon rule engine");
        couponRuleEngine.addRule(new BirthDaySpecialCouponRule());
        couponRuleEngine.addRule(new FestivalOfferCouponRule());
        couponRuleEngine.addRule(new FirstOrderCouponRule());
        couponRuleEngine.addRule(new HundredOrdersCouponRule());
        couponRuleEngine.addRule(new NewUserCouponRule());
        System.out.println("Adding rules to coupon rule engine completed");

        User user = new User();
        user.setCreatedAt(LocalDateTime.now());
        user.setUserName("user1");
        user.setDateOfBirth(LocalDate.now());
        user.setTotalOrders(20);
        CouponData couponData = new CouponData();
        couponData.setUser(user);

        couponRuleEngine.evaluateRules(couponData);

        System.out.println(String.format("Coupons available for user: %s are %s", user.getUserName(), couponData.getCoupons().toString()));
    }

}
