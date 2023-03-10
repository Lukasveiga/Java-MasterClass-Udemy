package com.masterclass.oldcontent.section19.banking;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class DepositProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(true, 200),
                Arguments.of(true, 600),
                Arguments.of(false, -200),
                Arguments.of(false, -600)
        );
    }
}
