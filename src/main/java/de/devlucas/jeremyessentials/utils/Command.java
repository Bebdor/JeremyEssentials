package de.devlucas.jeremyessentials.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Command
{
    String author() default "DevLucas";
    String command();
    String permission();
    String description();
    boolean isConsoleCommand();
    boolean isAdminCommand();
}