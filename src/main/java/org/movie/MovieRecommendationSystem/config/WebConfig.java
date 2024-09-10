package org.movie.MovieRecommendationSystem.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter());
    }
   
    // Override methods for customization, leave empty if not used

    @Override
    public void addFormatters(FormatterRegistry registry) {}

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {}

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {}

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {}

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {}

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {}

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {}

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {}

    @Override
    public void addCorsMappings(CorsRegistry registry) {}

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {}

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {}

    
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		
	}

}
