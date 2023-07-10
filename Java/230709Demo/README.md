### Step
1.  create db 資料   
2.  Staff  Dto and Staff Dao
3.  optDto and servlet (list & search)      **ok**    
4.  insert 社員 資料  
------------------------  

### 改善  
1. str 累加 StringBuffer  
2. input: radio select option checkbox 除了從後端撈出對應方法外？
3. Dao 各method()  <> ArrayList array 更好的寫法  
  
------------------------  
### 筆記  與  遇到的問題  
1. ArrayList<> al  只會顯示置位  forEach 方法
```  
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
2. null 的處理
```  
    // 1"null"字串  2比空字符""  3null  4比String[]的值
    System.out.println("null".equals(jstat));
    System.out.println("".equals(jstat));
    System.out.println(jstat==null);
    "0".equals(jobStat[0])
    // isEmpty()
```
3. 是對應servlet 的位置  
```
    <form action=""></form>
    // & web.xml 
```  

4. checkbox => req.getParameterValues("欄位name")
5. Dto 是 DB 的 column name
6. 三元條件式    條件式 ? ture :false  
