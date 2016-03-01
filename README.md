# dar-exception
DAR exceptions

# How to use SpringErrorLocaleContext
Create new Spring configuration or add in your existing configuration add the following restMessageSource bean:

        @Configuration
            public class RestConfiguration {
                private static final Logger LOGGER = LoggerFactory.getLogger(RestConfiguration.class);
                    @Bean
                    public MessageSource restMessageSource() {
                        if (LOGGER.isTraceEnabled()) {
                            LOGGER.trace("restMessageSource() - start");
                        }

                        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
                        source.setDefaultEncoding("UTF-8");
                        source.setFallbackToSystemLocale(false);
                        source.setBasename("classpath:/rest_i18n/bundle");
                        return source;
                    }
        }

Then in your ControllerAdvice error handler inject the MessageSource like following and pass the RestLocaleContext
as a parameter to ApiException#getErrorInfo

        @ControllerAdvice
            public class RestServiceErrorHandler {
                private staticы final Logger LOGGER = LoggerFactory.getLogger(RestServiceErrorHandler.class);

                @Autowired
                private MessageSource restMessageSource;

                @ExceptionHandler(ServerErrorRequestException.class)
                @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
                @ResponseBody
                public ErrorInfo serverError(HttpServletRequest req, ServerErrorRequestException ex) {
                    return ex.getErrorInfo(new RestLocaleContext(restMessageSource, req.getLocale()));
                }

                ...