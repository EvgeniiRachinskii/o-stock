package com.optimagrowth.ipvalidator;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;


import java.util.List;

import static java.util.Collections.singletonList;
import static org.keycloak.provider.ProviderConfigProperty.STRING_TYPE;

public class IPAuthenticatorFactory implements AuthenticatorFactory {

    public static final String ID = "IPAuthenticator";

    private static final Authenticator IP_AUTHENTICATOR = new IPAuthenticator();

    static final String ALLOWED_IP_ADDRESS = "allowedIpAddress";

    @Override
    public String getDisplayType() {
        return "IP Authenticator";
    }

    @Override
    public String getReferenceCategory() {
        return null;
    }

    @Override
    public boolean isConfigurable() {
        return true;
    }

    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        return new AuthenticationExecutionModel.Requirement[] {
          AuthenticationExecutionModel.Requirement.REQUIRED
        };
    }

    @Override
    public boolean isUserSetupAllowed() {
        return false;
    }

    @Override
    public String getHelpText() {
       return "You can only access via allowed IP Address";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        ProviderConfigProperty property = new ProviderConfigProperty();
        property.setType(STRING_TYPE);
        property.setName(ALLOWED_IP_ADDRESS);
        property.setLabel("IP Address from which sign ins are allowed");
        property.setHelpText("Only accept IP, no classless inter domain routing required");
        return singletonList(property);
    }

    @Override
    public Authenticator create(KeycloakSession keycloakSession) {
        return IP_AUTHENTICATOR;
    }

    @Override
    public void init(Config.Scope scope) {

    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return ID;
    }
}
