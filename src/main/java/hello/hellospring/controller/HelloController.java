package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
    //웹 어플리케이션에서 //hello라고 들어오 이 메서드를 호출해준다. 주소는 localhost:8080/hello이고 hello.html참고
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
    //public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
    // RequestParam의 required의 default값은 true 즉 무조건 name값을 넘겨줘야 한다.
        // 주소는 http://localhost:8080/hello-mvc?name=seongjun! 이런식으로 주소에 네임값을 임의로 명시
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        // http 통신 protocal의 body 부의 return 옆의 데이터를 내가 직접 넣어주겠다는 뜻, html의 body태그를 의미하는 것이 아님!
        // 이녀석은 html(view)파일이 없이 내가 적은 그대로 올라감, 소스보기를 누르면 출력되는 텍스트만 뜸
        // http://localhost:8080/hello-string?name=hansome -> hellohansome
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        // 참고로 이return은 templates의 hello 로 보내는 것이 아닌 객체 hello를 데이터 째로 반환하는 것이다 -> 실제로 소스보기 눌러도 데이터값으로 동일 html 값X
        // 위의 경우처럼 객체를 return 해주는 경우는 (HttpMessageConverter)JsonConverter가 문자를 return 하는 경우는 StringConverter가 동작한다.
        // http://localhost:8080/hello-api?name=son
    }

    //HelloController.Hello 로 HelloController안에 static class 생성
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

}
