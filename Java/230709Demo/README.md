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
4. date 預處理
  
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

###  遇到的問題  
>**Warning**  
A. SVN 競合問題     
   
----------------------------------
#### 計畫  
1. Delete insert update
2. Search time
3. 自己會寫Dao 不用抄  
4. list 分頁
5. ErrorMsg 後台  

待補  
SVN  Eclipse 改編碼  Debug  tomCat, JDK 對應verson解決方法  自動提示設定  
To be continued..  
[HackMD]([https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet#lines](https://hackmd.io/)https://hackmd.io/)  
