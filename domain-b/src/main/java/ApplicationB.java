import com.alibaba.fastjson.support.spring.FastJsonpResponseBodyAdvice;
import com.domaina.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@ComponentScan("com")
public class ApplicationB {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationB.class, args);
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CorsFilter());
		registration.addUrlPatterns("/testPreflighted2");
        registration.addUrlPatterns("/testHeader1");
        registration.addUrlPatterns("/testHeader2");
        registration.setName("corsFilter");
        registration.setOrder(1);
        return registration;
    }

    //配置fastjson的ResponseBodyAdvice
    @Bean
    public FastJsonpResponseBodyAdvice fastJsonpResponseBodyAdvice() {
        return new FastJsonpResponseBodyAdvice("callback");
    }

//    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
//    public DispatcherServlet dispatcherServlet() {
//        DispatcherServlet dispatcherServlet = new DispatcherServlet();
//        dispatcherServlet.setDispatchOptionsRequest(true);
//        return dispatcherServlet;
//    }

}