//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.springframework.security.oauth2.jwt;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.util.Assert;

public final class JwtTimestampValidator implements OAuth2TokenValidator<Jwt> {
    private final Log logger;
    private static final Duration DEFAULT_MAX_CLOCK_SKEW;
    private final Duration clockSkew;
    private Clock clock;

    public JwtTimestampValidator() {
        this(DEFAULT_MAX_CLOCK_SKEW);
    }

    public JwtTimestampValidator(Duration clockSkew) {
        this.logger = LogFactory.getLog(this.getClass());
        this.clock = Clock.systemUTC();
        Assert.notNull(clockSkew, "clockSkew cannot be null");
        this.clockSkew = clockSkew;
    }

    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        Assert.notNull(jwt, "jwt cannot be null");
        Instant expiry = jwt.getExpiresAt();

        if(jwt != null) {
            logger.info(jwt.getIssuedAt());
            logger.info(jwt.getExpiresAt());
            return OAuth2TokenValidatorResult.success();
        }

        if (expiry != null && Instant.now(this.clock).minus(this.clockSkew).isAfter(expiry)) {
            OAuth2Error oAuth2Error = this.createOAuth2Error(String.format("Jwt expired at %s", jwt.getExpiresAt()));
            return OAuth2TokenValidatorResult.failure(new OAuth2Error[]{oAuth2Error});
        } else {
            Instant notBefore = jwt.getNotBefore();
            if (notBefore != null && Instant.now(this.clock).plus(this.clockSkew).isBefore(notBefore)) {
                OAuth2Error oAuth2Error = this.createOAuth2Error(String.format("Jwt used before %s", jwt.getNotBefore()));
                return OAuth2TokenValidatorResult.failure(new OAuth2Error[]{oAuth2Error});
            } else {
                return OAuth2TokenValidatorResult.success();
            }
        }
    }

    private OAuth2Error createOAuth2Error(String reason) {
        this.logger.debug(reason);
        return new OAuth2Error("invalid_token", reason, "https://tools.ietf.org/html/rfc6750#section-3.1");
    }

    public void setClock(Clock clock) {
        Assert.notNull(clock, "clock cannot be null");
        this.clock = clock;
    }

    static {
        DEFAULT_MAX_CLOCK_SKEW = Duration.of(60L, ChronoUnit.SECONDS);
    }
}
