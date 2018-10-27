package cn.wangjie.movie.controller;


import cn.wangjie.movie.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.SortedMap;

/**
 * @program: SpringCloudDemo
 * @description: 用户controller
 * @author: WangJie
 * @create: 2018-07-08 14:08
 **/
@Slf4j
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping("/user/get/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return  this.restTemplate.getForObject("http://spring-cloud-user/user/get/"+id,User.class);
    }

    @GetMapping("/user/get/loadBalance/{id}")
    public String getUserLoadBalance(@PathVariable("id") Integer id){
        ServiceInstance serviceInstance =  loadBalancerClient.choose("spring-cloud-user");
        System.out.println("host:"+serviceInstance.getHost());
        System.out.println("port:"+serviceInstance.getPort());
        System.out.println("url:"+serviceInstance.getUri());
        System.out.println("--------");
        return "loadBalance";
    }

}
