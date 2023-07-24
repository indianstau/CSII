# Spring Boot  
起手式  
引入依賴  共八個

>Spring Web  
>Spring Boot DevTools  
>MyBatis Framework  
>H2 Datebase  
>MySQL Driver  
>MariaDB Driver  
>Thymeleaf
>Lombok

-----------------    
    
 ### note  
 1.@RestController = @Controller + @ResponseBody  

 2.代參數方法：  
 Method  
 ("/{author}");  
 (@PathVariable String author)  

 Front end  
 [[${key}]]  
 p tag <> 裡 th:text="${key}"   
 (th:from thymeleaf 依賴)   

 3.前端的name --> 後端 @ModelAttribute("name") 型別  命名  
 4.後端  Model model --->  顯示回前端
 model.addAttribute("key", param1  +  param2)  

 5.前端 th:action="@{/hom}" 對應  Controller @RequestMapping("/hom")
 6.return "對應html name"  

 7.@Autowired  建構參數  , entity Dto  
 8.resources/applicatio.properties   放連接DB  url ps drive  
 9.Repository.xml  專放SQL query 要對應 resources/file (jp/csii/repository)  interface (my bitis if test)  
 10.Service java clasee sql findAll findByName,  

 -----------  
 ### 補充  
 MVC 對應 spring boot 資料結構  說明網站  
 (目錄結構)[https://morosedog.gitlab.io/springboot-20190314-springboot3/]   
 (目录结构)[https://blog.csdn.net/biedazhangshu/article/details/117330528]
 

pom.xml 查看依賴  

