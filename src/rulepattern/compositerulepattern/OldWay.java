package rulepattern.compositerulepattern;

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
        String todayDateInString = LocalDate.now().toString();
        LocalDate userBirthDay = user.getDateOfBirth();
        if (todayDate.equals(userBirthDay) && festivalDates.contains(todayDateInString)) {
            input.getCoupons().add(Coupon.BIRTHDAY_FESTIVE_OFFER);
            System.out.println("Added BIRTHDAY_FESTIVE_OFFER coupon");
        }

        LocalDateTime presentDate = LocalDateTime.now();
        LocalDateTime userAccountCreated = user.getCreatedAt();
        long daysBetween = ChronoUnit.DAYS.between(presentDate, userAccountCreated);
        if (daysBetween <= 7 && (todayDate.equals(userBirthDay) || festivalDates.contains(todayDateInString))) {
            input.getCoupons().add(Coupon.NEW_USER_COMBO_OFFER);
            System.out.println("Added coupon NEW_USER_COMBO_OFFER");
        }
    }
}
