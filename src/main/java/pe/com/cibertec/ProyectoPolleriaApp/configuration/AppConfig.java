package pe.com.cibertec.ProyectoPolleriaApp.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.com.cibertec.ProyectoPolleriaApp.mappers.PedidoMapper;

@Configuration
public class AppConfig {

    @Bean
    public PedidoMapper pedidoMapper() {
        return Mappers.getMapper(PedidoMapper.class);
    }
}
