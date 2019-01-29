package cn.egbert.shop;

import cn.egbert.shop.dao.UserDoMapper;
import cn.egbert.shop.dataobject.UserDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"cn.egbert.shop"})
@RestController
@MapperScan("cn.egbert.shop.dao")
public class App {
    @Autowired
    private UserDoMapper userDoMapper;

    @RequestMapping("/")
    public String home() {
        UserDo userDo = userDoMapper.selectByPrimaryKey(1);
        if (userDo == null) {
            return "没有找到用户";
        } else {
            return userDo.getName();
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
