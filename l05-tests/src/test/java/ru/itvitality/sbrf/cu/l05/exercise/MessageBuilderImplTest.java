package ru.itvitality.sbrf.cu.l05.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName( "MessageBuilder должен" )
class MessageBuilderImplTest {

    MessageBuilder messageBuilder;
    MessageTemplateProvider provider;

    @BeforeEach
    void setUp() {
        provider = Mockito.mock( MessageTemplateProvider.class );
        when(provider.getMessageTemplate( "hello" ))
                .thenReturn( "Hello, %s! %s" );

        messageBuilder = new MessageBuilderImpl( provider );
    }

    @Test
    @DisplayName( "собрать корретно приветствие Котенку от Солнышка" )
    void buildMessage() {
        String result = messageBuilder.buildMessage( "hello", "Kitty", "Sunny" );
        assertEquals( "Hello, Kitty! Sunny", result );
        verify( provider, Mockito.times( 1 ) ).getMessageTemplate( anyString() );


        assertThat(result)
                .isNotEmpty()
                .endsWith( "Sunny" );
    }

    @Test
    @DisplayName( "кинуть исключение TemplateNotFound если нет шаблона" )
    void throwExceptionIfTemplateNotExist() {
        assertThrows( TemplateNotFoundException.class, () ->
                messageBuilder.buildMessage( "hello1", "Kitty", "Sunny" )
        );
        verify( provider, Mockito.times( 1 ) ).getMessageTemplate( anyString() );
    }
}