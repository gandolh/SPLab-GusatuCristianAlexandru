package ro.uvt.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ro.uvt.info.difexamples.ClientComponent;
import ro.uvt.info.difexamples.SingletonComponent;
import ro.uvt.info.difexamples.TransientComponent;

@SpringBootApplication
public class MySpringApplication {
    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(MySpringApplication.class, args);
        DiExamples(context);

        
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }


    private  static void DiExamples(ApplicationContext context){
        // Gets an instance of TransientComponent from the DI context
        TransientComponent transientBean =
                context.getBean(TransientComponent.class);
        transientBean.operation();
        // Note that every time an instance is required,
        // the DI context creates a new one
        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();
        // Gets an instance of SingletonComponent from the DI context
        // Note that the unique instance was created while
        // application was loaded, before creating
        // the transient instances
        SingletonComponent singletonBean =
                context.getBean(SingletonComponent.class);
        singletonBean.operation();
        // Note that every time an instance is required,
        // the DI returns the same unique one
        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();
        // Gets an instance of another class that
        // requires singleton/transient components
        // Note where this instance was created and what beans
        // were used to initialize it
        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();
// One can also request an instance from DI context by name
        c = (ClientComponent) context.getBean("clientComponent");
        c.operation();
    }
}