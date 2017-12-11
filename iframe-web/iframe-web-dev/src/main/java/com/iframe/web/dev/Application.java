package com.iframe.web.dev;

import com.iframe.core.util.SystemUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author janko
 * @date 19/11/2017
 * @desc
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		SystemUtil.openUrlInBrowser("http://localhost:8888/info");
	}

}
