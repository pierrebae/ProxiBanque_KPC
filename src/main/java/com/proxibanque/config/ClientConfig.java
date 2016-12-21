package com.proxibanque.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * 
 * @author Pierre Baele, Clément Lacorte, Katherine Merkulova
 * @see classe de configuration des annotations spring
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"com.proxibanque"})
public class ClientConfig {

}
