package rulepattern;

import rulepattern.model.Coupon;
import rulepattern.model.CouponData;
import rulepattern.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class OldWay {

    private static final List<String> festivalDates = List.of("2023-01-01", "2023-10-02");

    public void addCoupons(CouponData input) {
        final User user = input.getUser();
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }

        LocalDate todayDate = LocalDate.now();
        LocalDate userBirthDay = user.getDateOfBirth();
        if (todayDate.equals(userBirthDay)) {
            input.getCoupons().add(Coupon.BIRTHDAY_SPECIAL);
            System.out.println("Added coupon BIRTHDAY_SPECIAL");
        }

        String todayDateInString = LocalDate.now().toString();
        if (festivalDates.contains(todayDateInString)) {
            input.getCoupons().add(Coupon.FESTIVAL_OFFER);
            System.out.println("Added coupon FESTIVAL_OFFER");
        }

        if (user.getTotalOrders() == 0) {
            input.getCoupons().add(Coupon.FIRST_ORDER);
            System.out.println("Added coupon FIRST_ORDER");
        }

        final long totalOrders = input.getUser().getTotalOrders() + 1;
        if (totalOrders == 100) {
            input.getCoupons().add(Coupon.ORDER_100);
            System.out.println("Added coupon ORDER_100");
        }

        LocalDateTime presentDate = LocalDateTime.now();
        LocalDateTime userAccountCreated = user.getCreatedAt();
        long daysBetween = ChronoUnit.DAYS.between(presentDate, userAccountCreated);
        if (daysBetween <= 7) {
            input.getCoupons().add(Coupon.NEW_USER);
            System.out.println("Added coupon NEW_USER");
        }
    }
}
