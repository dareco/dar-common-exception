package kz.dar.common.exception.impl;

import kz.dar.common.exception.ErrorLocaleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * @author Sabyrzhan Tynybayev
 * @date 01/03/16
 */
public class SpringErrorLocaleContext implements ErrorLocaleContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringErrorLocaleContext.class);

    private MessageSource messageSource;
    private Locale locale;

    public SpringErrorLocaleContext(MessageSource messageSource, Locale locale) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    @Override
    public String getLocalizedMessage(long fullErrorCode) {
        try {
            return messageSource.getMessage(String.valueOf(fullErrorCode), new Object[] { }, locale);
        } catch (Exception e) {
            LOGGER.warn("Locale for error code: {} not found. Returning null message", fullErrorCode);
            return null;
        }
    }
}
