package com.thales.test.service;

import com.thales.test.model.Dto.ResponseEmployee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class EmployeeServiceImpl extends AbstractEmployee implements EmployyeService{

    public EmployeeServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public ResponseEmployee getAll() {
        String uri = baseUrl+"/employees";
        //log.info("consult the services");
        HttpEntity<Void> requestEntity = new HttpEntity<>(this.headersAdd());
        ResponseEntity<ResponseEmployee> response = restTemplate.getForEntity(uri,ResponseEmployee.class);
        if(response.getStatusCode().is2xxSuccessful()){
           // log.info("susscefull", response.getBody().getStatus() );
        }

        return response.getBody();
    }
}
