package com.jade.serviceconsumer.config.balance;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CustomBalance implements IRule {

    private ILoadBalancer iLoadBalancer;

    private List<Integer> excludePorts;

    public CustomBalance(List<Integer> excludePorts) {
        this.excludePorts = excludePorts;
    }

    @Override
    public Server choose(Object key) {
        List<Server> servers = iLoadBalancer.getAllServers();
        List<Server> availableServers = getAvailableServers(servers);

        System.out.println("availableServers: "+availableServers);

        return getAvailableRandomServer(availableServers);
    }

    private Server getAvailableRandomServer(List<Server> servers) {
        int index = new Random().nextInt(servers.size());
        return servers.get(index);
    }

    private List<Server> getAvailableServers(List<Server> servers) {

        if(CollectionUtils.isEmpty(excludePorts)){
            return servers;
        }

        List<Server> availableServers = new ArrayList<>();

        for (Server server : servers) {
            boolean flag = true;
            int serverPort = server.getPort();
            for (Integer port : excludePorts) {
                if(serverPort == port){
                    flag = false;
                    break;
                }
            }
            if(flag){
                availableServers.add(server);
            }

        }

        return availableServers;

    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return iLoadBalancer;
    }
}
