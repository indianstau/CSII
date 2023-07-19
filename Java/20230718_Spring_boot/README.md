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

 5.  前端 th:action="@{/hom}" 對應  Controller @RequestMapping("/hom")
 6.  return "對應html name"  

pom.xml 查看依賴  

