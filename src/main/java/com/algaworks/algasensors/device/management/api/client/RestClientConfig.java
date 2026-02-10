package com.algaworks.algasensors.device.management.api.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Bean
    public SensorMonitoringClient sensorMonitoringClient(RestClientFactory factory){
        RestClient restClient = factory.temperaturaMonitoringRestClient();
        //Para gerar a instancia da interface(SensorMonitoringClient) de forma dinamica sem precisar implementar de fato a interface
        //necessario combinar as duas informações, o restClient e a interface
        //pra isso o Spring já prove de uma classe chamada RestClientAdapter
        RestClientAdapter adapter = RestClientAdapter.create(restClient);

        //uma factory é criada pelo proprio Spring
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builderFor(adapter).build();

        return proxyFactory.createClient(SensorMonitoringClient.class);

        //O adapter é repassado pro ProxyFactory e o proxyFactory com essa informação do RestClient e do adapter consegue gerar de forma
        //dinamica a interface SensorMonitoringClient com base nas anotações

        //O RestClient continua com o baseUrl mas agora ele combina com os paths e vai fazer as chamadas http utilizando o RestClient
        //Da mesma forma com que implementamos no SensorMonitoringClientIMpl um a um, mas ele vai fazer isso de uma forma dinamica,
        //Sem a necessidade dessa implementação


    }
}
