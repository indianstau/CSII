### Step
1.  create db 資料   
2.  Staff  Dto and Staff Dao
3.  optDto and servlet (list & search)      **ok**    
4.  insert 社員 資料
5.  delete servlet and dao jsMsg
------------------------  

### 改善  
1. str 累加 StringBuffer  
2. input: radio select option checkbox 除了從後端撈出對應方法外？
3. Dao 各method()  <> ArrayList array 更好的寫法
4. date 預處理 session  
5. 不寫明碼  a tag :class="deleteBtn" href="/bmsweb/staffDelete?id=<%=dto.getSyain_id() %>"  削除 /a tag    
   外 JavaScript 寫法  ?.click()   ???  
[不明碼](https://codepen.io/san__/pen/OJazwQo?editors=0011)  未測試
6. table 用 ts_setting 抓所有select & check & radio 欄位  dao 寫兩個方法  
7. 分頁  and ErrorMsg 未寫  
8. Search 選的項目 存在Session 裡  撈出後 顯示出來  
  
------------------------  
### 筆記  與  
> **Note**  
>1. ArrayList<> al  只會顯示置位  forEach 方法
```java  
   for(int i=0;i<sexAl.size();i++) {
	// ArrayList.get(i).getMethod();
      System.out.println(sexAl.get(i).getId());
      System.out.println(comAl.get(0).getCom());
   }
   for(StaffOptComDto arr:comAl) {
	//arr.getMethod();
      System.out.print(arr.getId());
      System.out.println(arr.getCom());
   }
   sexAl.forEach(System.out::println);

```  
>2. null 的處理
```java   
    // 1"null"字串  2比空字符""  3null  4比String[]的值
    System.out.println("null".equals(jstat));
    System.out.println("".equals(jstat));
    System.out.println(jstat==null);
    "0".equals(jobStat[0])
    // isEmpty()
```
>3. 是對應servlet 的位置  
```html  
    <form action=""></form>
    <!-- & web.xml  --> 
```  

>4. checkbox => req.getParameterValues("欄位name")
>5. Dto 是 DB 的 column name
>6. 三元判斷式    條件式 ? ture :false
>7. tr:nth-child(even)  CSS
>8. JavaScript querySelectorAll  & querySelector (只抓第一個)   
   window  &  document XXXXX
```javascript  
const btn = document.querySelectorAll('.deleteBtn');
console.log(btn); //複數
    //點哪裡都會顯示  
    //document.addEventListener('click', showDelMsg);    X  
    //window.addEventListener('click', showDelMsg);      X  
  // element target -> a  btn[0]~btn[13] ...  
	btn.forEach(function (a){
		a.addEventListener('click', showDelMsg);
	});
```
9.三元左邊要是變數  
```jsp
	<% int syoKin = stfIdto.getSYOKUGYO_KIND(); %>  	
	<option value="<%=arr.getId() %>" <%=syoKin == arr.getId()?"selected":"" %>>  
```


###  遇到的問題  
>**Warning**  
A. SVN 競合問題     
   
----------------------------------



待補  
SVN  Eclipse 改編碼  Debug  tomCat, JDK 對應verson解決方法  自動提示設定  
To be continued..  
[HackMD](https://hackmd.io/)  

### 未完成 與 錯誤  
1.seesion 存search 條件 and 預撈取  
2.dao 寫錯了  一個表格 抓全部 選項 2 mdthod  
3.list 分頁  
4.ErrorMsg 後台  

100 -> javascript   
spring boot  
