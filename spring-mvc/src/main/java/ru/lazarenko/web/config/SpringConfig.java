package ru.lazarenko.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration //специализированный компонент (@Component), позволяющий создавать бины, являющиеся конфигурационными.
@EnableWebMvc //импортирует необходимые настройки (бины) для работы веб-приложения
@ComponentScan("ru.lazarenko.web")
@PropertySource("classpath:application.properties")
public class SpringConfig {
}
