package com.linqingxuan.datachoreography.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
class UserServiceBeanTest extends Specification {

    @Autowired
    private UserService userService;

    //@Unroll
    def "test findByName with input #name return #result"() {
        expect:
        userService.findByName(name) == result

        where:
        name << ["k", "i", "kk"]
        result << [new User("k", 1, "123"), new User("i", 2, "456"), null]
        //print(result
    }

    @Unroll
    def "test login with input #name and #passwd throw #errMsg"() {
        when:
        userService.login(name, passwd)

        then:
        def e = thrown(Exception)
        e.message == errMsg

        where:
        name    |   passwd  |   errMsg
        "kd"     |   "1"     |   "${name}不存在"
        "k"     |   "1"     |   "${name}密码输入错误"

    }
}
