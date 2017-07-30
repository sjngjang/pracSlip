package net.sj.slipp.config;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages={
		"net.sj.slipp.web.controller"
})
@EnableWebMvc
public class WebAppContext extends WebMvcConfigurerAdapter{
	
/*	protected static final String PROPERTY_NAME_MVC_VIEW_PREFIX="spring.mvc.view.prefix";
	protected static final String PROPERTY_NAME_MVC_VIEW_SUEFIX="spring.mvc.view.suffix";
	
	@Resource
	private Environment env;
*/	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}
	
/*	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix(env.getRequiredProperty(PROPERTY_NAME_MVC_VIEW_PREFIX));
		viewResolver.setSuffix(env.getRequiredProperty(PROPERTY_NAME_MVC_VIEW_SUEFIX));
		
		return viewResolver;
	}*/
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/static/" };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
/*        if (!registry.hasMappingForPattern("static/**")) {
            registry.addResourceHandler("static/**").addResourceLocations("classpath:/static/");
        }*/
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
        }
    }
	
/*	@Bean
	public SimpleMappingExceptionResolver exceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		
		Properties exceptionMappings = new Properties();
		
		exceptionMappings.put("bang.sj.blog.demo.article.validation.PostNotFoundException", "error/404");
		exceptionMappings.put("java.lang.Exception", "error/error");
		exceptionMappings.put("java.lang.RuntimeException", "error/error");
		
		exceptionResolver.setExceptionMappings(exceptionMappings);
		
		Properties statusCodes=new Properties();
		statusCodes.put("error/404", "404");
		statusCodes.put("error/error","500");
		
		exceptionResolver.setStatusCodes(statusCodes);
		
		return exceptionResolver;
	}*/
	
	 @Override
	    public void addInterceptors(InterceptorRegistry registry){
	        registry.addInterceptor(new WebAppCustomIntercepter()).addPathPatterns("/**");
	}
	
	// Conversion and Formatting of date and number
}
