package com.masterclass.oldcontent.section19.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankingAccountTestParameterized {

    private BakingAccount account;

    @BeforeEach
    void setup() {
        account = new BakingAccount("FirstParameterizedName", "LastParameterizedName");
    }

    @ParameterizedTest
    //@MethodSource("com.masterclass.section19.banking.DepositProvider.provideArguments")
    @ArgumentsSource(DepositProvider.class)
    void testDeposit(boolean result, double amount) {
        assertEquals(result, account.deposit(amount));
    }

    @ParameterizedTest
    @MethodSource("withdrawTestProvider")
    void testWithdraw(boolean result, double amount){
        account.deposit(200);
        assertEquals(result, account.withdraw(amount, false));
    }

    private static Stream<Arguments> withdrawTestProvider() {
        return Stream.of(
                Arguments.of(true, 200),
                Arguments.of(false, 400),
                Arguments.of(true, 0),
                Arguments.of(false, -200)
        );
    }
}
