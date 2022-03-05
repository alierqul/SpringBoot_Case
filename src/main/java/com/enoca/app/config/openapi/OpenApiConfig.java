package com.enoca.app.config.openapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Enoca Challange Question 6")
                        .description("Local database kurulumu (mysql, postgresql veya herhangi bir database)\n" +
                                "- Java spring uygulaması ayağa kaldırılması,\n" +
                                "- İki adet tablo yer alamalı ve bu tabloların birbirleriyle bağı olmalıdır. (Örn: şirket ve çalışan\n" +
                                "gibi),\n" +
                                "- Java spring uygulamasında ekleme,silme,güncelleme,listeleme gibi servisler yer almalıdır ve\n" +
                                "responseda yapılan işlem detayı return edilmelidir.\n" +
                                "- Ekleme,silme,güncelleme,listeleme işlemlerini postman vb ile işlem yapılabilmelidir.\n" +
                                "Bu adımlar sırasıyla izlenip java uygulaması üzerinden database’ e kayıt atılmalı (Herhangi\n" +
                                "bir kayıt olabilir fark etmez. Database'de bir tablo açılıp o tabloya değer girilmesi java isteği\n" +
                                "üzerinden). Daha sonra aynı istek atılan uygulama ile (örnek postman ...) get ve list java\n" +
                                "spring endpointleri çağırılarak, database e atılan kayıt response olarak dönülmeli.\n" +
                                "MVC deki model ve kontroller akışının güzel kurgulanması ve uygulama ayağı nasıl\n" +
                                "kaldırılıp servislerin nasıl kullanıldığına dair bir döküman hazırlanmalıdır. Bu proje için\n" +
                                "kaynak kodu ile iletilmesi gerekmektedir."



                        )
                        .termsOfService("terms")
                        .contact(new Contact().email("alierqul@hotmail.com"))
                        .license(new License().name("Github Linki").url("https://github.com/alierqul/SpringBoot_Case"))
                        .version("1.0")
                );
    }
}
