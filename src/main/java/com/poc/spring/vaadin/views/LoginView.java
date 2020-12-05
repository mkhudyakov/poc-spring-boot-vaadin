package com.poc.spring.vaadin.views;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("login")
public class LoginView extends VerticalLayout {

    public LoginView() {

        LoginForm loginForm = new LoginForm();
        loginForm.setI18n(createPortugueseI18n());

        loginForm.addLoginListener(e -> {
            String username = e.getUsername();
            String password = e.getPassword();

            if (!"admin".equals(username) || !"admin".equals(password)) {
                loginForm.setError(true);
            } else {
                Notification.show("Success")
                        .setPosition(Notification.Position.MIDDLE);
            }
        });

        loginForm.addForgotPasswordListener(e -> {
            Notification.show("Forgot password link taped")
                .setPosition(Notification.Position.MIDDLE);
        });

        VerticalLayout vertical = new VerticalLayout();
        vertical.setSizeFull();
        vertical.setHorizontalComponentAlignment(Alignment.CENTER);
        vertical.setAlignItems(Alignment.CENTER);
        vertical.add(loginForm);

        add(vertical);
    }

    private LoginI18n createPortugueseI18n() {
        final LoginI18n i18n = LoginI18n.createDefault();

        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("Nome do aplicativo");
        i18n.getHeader().setDescription("Descrição do aplicativo");
        i18n.getForm().setUsername("Usuário");
        i18n.getForm().setTitle("Acesse a sua conta");
        i18n.getForm().setSubmit("Entrar");
        i18n.getForm().setPassword("Senha");
        i18n.getForm().setForgotPassword("Esqueci minha senha");
        i18n.getErrorMessage().setTitle("Usuário/senha inválidos");
        i18n.getErrorMessage()
                .setMessage("Confira seu usuário e senha e tente novamente.");
        i18n.setAdditionalInformation(
                "Caso necessite apresentar alguma informação extra para o usuário"
                        + " (como credenciais padrão), este é o lugar.");
        return i18n;
    }
}
