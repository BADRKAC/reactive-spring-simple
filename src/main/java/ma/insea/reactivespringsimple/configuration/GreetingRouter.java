package ma.insea.reactivespringsimple.configuration;

import ma.insea.reactivespringsimple.handler.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        //The router listens for traffic on the /hello path and returns the value provided
        // by our reactive handler class.
        return RouterFunctions
                .route(GET("/hello")
                        .and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello);
    }
}