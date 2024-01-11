package rulepattern.compositerulepattern;

import rulepattern.compositerulepattern.engine.ICouponRuleEngine;
import rulepattern.compositerulepattern.engine.impl.DefaultCouponRuleEngine;
import rulepattern.compositerulepattern.rules.impl.BirthdayFestiveComboCouponRule;
import rulepattern.compositerulepattern.rules.impl.NewUserComboCouponRule;
import rulepattern.model.CouponData;
import rulepattern.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Driver {

    public static void main(String[] args) {
        // Initialize user data object
        User user = new User();
        user.setCreatedAt(LocalDateTime.now());
        user.setUserName("user1");
        user.setDateOfBirth(LocalDate.now());
        user.setTotalOrders(20);
        CouponData couponData = new CouponData();
        couponData.setUser(user);

        /// Old way
        System.out.println("With Old way");
        OldWay oldWay = new OldWay();
        oldWay.addCoupons(couponData);

        System.out.println(String.format("Coupons available for user: %s are %s", user.getUserName(), couponData.getCoupons().toString()));


        System.out.println("------------------------------");

        /// New way
        System.out.println("With New way");
        ICouponRuleEngine couponRuleEngine = new DefaultCouponRuleEngine();
        couponRuleEngine.addRule(new NewUserComboCouponRule());
        couponRuleEngine.addRule(new BirthdayFestiveComboCouponRule());

        // Evaluate rules
        couponData.setCoupons(null);
        couponRuleEngine.evaluateRules(couponData);

        // Result
        System.out.println(String.format("Coupons available for user: %s are %s", user.getUserName(), couponData.getCoupons().toString()));
    }
}
