package com.optimagrowth.ipvalidator;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.Authenticator;
import org.keycloak.models.AuthenticatorConfigModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

import java.util.Map;

@Slf4j
public class IPAuthenticator implements Authenticator {

    private static final String IP_BASED_OTP_CONDITIONAL_USER_ATTRIBUTE = "ip_based_otp_conditional";


    @Override
    public void authenticate(AuthenticationFlowContext context) {
        KeycloakSession session = context.getSession();
        RealmModel realmModel = context.getRealm();
        UserModel userModel = context.getUser();

        String remoteIpAddress = context.getConnection().getRemoteAddr();
        String allowedIpAddress = getAllowedIpAddress(context);

        if(!allowedIpAddress.equals(remoteIpAddress)) {
            log.info("IPs do not match. Realm %s expected %s but user %s logged from %s", realmModel.getName(),
                    allowedIpAddress, userModel.getUsername(), remoteIpAddress);
        }
    }


    private String getAllowedIpAddress(AuthenticationFlowContext context) {
        AuthenticatorConfigModel configModel = context.getAuthenticatorConfig();
        Map<String, String> configuration = configModel.getConfig();
        return configuration.get(IPAuthenticatorFactory.ALLOWED_IP_ADDRESS);
    }

    @Override
    public void action(AuthenticationFlowContext authenticationFlowContext) {

    }

    @Override
    public boolean requiresUser() {
        return true;
    }

    @Override
    public boolean configuredFor(KeycloakSession keycloakSession, RealmModel realmModel, UserModel userModel) {
        return true;
    }

    @Override
    public void setRequiredActions(KeycloakSession keycloakSession, RealmModel realmModel, UserModel userModel) {

    }

    @Override
    public void close() {

    }
}
