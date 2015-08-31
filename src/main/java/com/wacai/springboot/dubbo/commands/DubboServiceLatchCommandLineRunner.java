package com.wacai.springboot.dubbo.commands;

import com.wacai.goodies.lifecycle.ShutdownLatch;
import org.springframework.boot.CommandLineRunner;


public class DubboServiceLatchCommandLineRunner implements CommandLineRunner {

    private String domain = "com.wacai.lifecycles";

    @Override
    public void run(String... args) throws Exception {
        ShutdownLatch latch = new ShutdownLatch(getDomain());
        latch.await();
    }


    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
