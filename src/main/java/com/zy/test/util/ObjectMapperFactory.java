package com.zy.test.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

public final class ObjectMapperFactory {
    private static final ObjectMapper defaultObjectMapper;

    static {
        defaultObjectMapper = new ObjectMapper();
    }

    private static final ObjectMapper lowerCaseObjectMapper;

    static {
        lowerCaseObjectMapper = new ObjectMapper();
        lowerCaseObjectMapper.setPropertyNamingStrategy(
                PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }

    private static final ObjectMapper memberObjectMapper;

    static {
        memberObjectMapper = new ObjectMapper();
        /* 하위호환성을 위해 @JsonProperty 어노테이션을 사용하는 경우가 있어서 LowerCaseWithUnderscoresStrategy 를 사용하면서 이를
           존중해주려면 다음과 같이 해야함 */
        memberObjectMapper.setPropertyNamingStrategy(new PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy() {
            @Override
            public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
                final JsonProperty annotation = method.getAnnotation(JsonProperty.class);
                if (annotation != null) {
                    return annotation.value();
                }
                return super.nameForSetterMethod(config, method, defaultName);
            }

            @Override
            public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
                final JsonProperty annotation = method.getAnnotation(JsonProperty.class);
                if (annotation != null) {
                    return annotation.value();
                }
                return super.nameForGetterMethod(config, method, defaultName);
            }
        });
    }

    private static final ObjectMapper cookierunRequestObjectMapper;

    static {
        cookierunRequestObjectMapper = new ObjectMapper();
        cookierunRequestObjectMapper.getFactory().enable(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
    }

    private ObjectMapperFactory() {
    }

    /** 기본적으로 사용하는 ObjectMapper */
    public static ObjectMapper getDefaultObjectMapper() {
        return defaultObjectMapper;
    }

    /** Java의 getFirstName 와 같은 필드를 JSON의 first_name 필드로 매핑하는 ObjectMapper. Couchbase 저장 시 사용된다. */
    public static ObjectMapper getLowerCaseObjectMapper() {
        return lowerCaseObjectMapper;
    }

    /**
     * LowerCaseObjectMapper 와 같으나 Member 객체의 특정 필드의 하위호환성 유지를 위하여 특수하게 사용하는 ObjectMapper.
     * 필드 이름을 정할 때 LowerCase 전략을 사용하면서 getter/setter에 정의되어있는 @JsonProperty Annotation을 존중한다.
     *
     * 주의: 새롭게 정의하는 Couchbase Mapper 에서는 이 Mapper를 사용하지 말고 LowerCaseObjectMapper 를 사용하시오.
     */
    public static ObjectMapper getMemberObjectMapper() {
        return memberObjectMapper;
    }

    /** 클라이언트에서 오는 JSON 요청을 처리하기위한 ObjectMapper */
    public static ObjectMapper getCookierunRequestObjectMapper() {
        return cookierunRequestObjectMapper;
    }
}
