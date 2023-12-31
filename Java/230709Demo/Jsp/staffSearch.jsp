<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,bms.staff.dto.*"%>
<!DOCTYPE html>
<html lang="jp">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>社員一覧表 | 研修システム</title>
<style>
    body{margin: 0;}
    ul{list-style: none;padding:0;}
    table{width:100%;margin-bottom:10%;border-collapse: collapse;}
    th, td{padding:12px 8px;}
    .wrap{padding: 0 2%;}
    h1{text-align: center;font-weight: bold;}
    span{font-size:40px;color:#B0E0E6;}
    h2{background:#f3f3f3;border-radius: 4px;}
    .txtBnot{border: none;}

    .txtc, table{text-align: center;}
    .txtc input, .txtc button{
    	border:none;border-radius:4px;padding:4px 30px;
    	background-color: #B0E0E6;font-size:24px;
    }
    .txtc a, .count a{
    	text-decoration: none;padding: 8px 16px;
    	border-radius: 4px;color: black;}
    .unitLi{margin-bottom: 2%;display:flex;justify-content: space-evenly}
    .unitLi div{display:inline;width:304px;}
    .unitLi input, .unitLi select{padding:4px 8px;}
    .unitLi select, .move{margin-left:10px;}
    .in input{zoom:150%;vertical-align: top;}

    .space{margin-left: 15%;}
    .count{text-align:right;margin: 0 3% 1% 0;}
    .count a{margin-left:6%;}

    tr:nth-child(even){background-color:#EDEDED;}
    tr:hover{background-color: lightgreen;}
    .bg, tr:first-child:hover{background-color:#B0E0E6;}
</style>
</head>
<body>
<div class="wrap">
    <h1>社內統合管理システム</h1>
	<div><a href="/bmsweb/menu.jsp" style="margin-right:3%;">
    		<img src="https://cdn-icons-png.flaticon.com/512/151/151409.png" style="width:3%;"></a>
		<lable>登陸時間:<input type="text" class="txtBnot"></lable>
	</div>
    <h2><span>■</span>社員管理</h2>
    <h3><span>■</span>検索条件</h3>
<%
    ArrayList<StaffOptComDto> alCom = (ArrayList) request.getAttribute("comAl");
    ArrayList<StaffOptPjtDto> alPjt = (ArrayList) request.getAttribute("pjtAl");
%>
<!-- action 對應xml servlet path  -->
    <form action="/bmsweb/staffSearch" method="post">
        <ul><li class="unitLi">
        	<lable for="com">所属会社<select name="com">
        		<option value="0" disabled selected>Please Choose It</option>
<%  if(alCom != null){
	for(StaffOptComDto arr:alCom){
%>         		<option value="<%=arr.getId() %>"><%=arr.getCom() %></option>
<% }} %>   	   </select>
		</lable><!--   <input type="text" name="com">   -->
                <lable for="name">社員名<input type="text" name="name" class="move"></lable>
            </li>
            <li class="unitLi">
                <lable for="pjt">職業種類<select name="pjt" style="width:230px;">
        		<option value="" disabled selected>Please Choose It</option>
<%  if(alPjt != null){
	for(StaffOptPjtDto arr:alPjt){
%>         		<option value="<%=arr.getId() %>"><%=arr.getPjt() %></option>
<% }} %>   	   </select>
		</lable><!--   <input type="text" name="pjt">   -->
                <div class="in">
                    <input type="checkbox" name="jobstat" value="0">非在籍
                    <input type="checkbox" name="jobstat" value="1" class="space" checked>在籍

<!--                <lable for="on" class="space">在籍<input type="checkbox" name="on" value="0"></lable>
                    <lable for="off">非在籍<input type="checkbox" name="off" value="1"></lable>                          -->
                </div>
            </li>
            <li class="txtc"><button type="submit" style="cursor:pointer;">検索</button></li>
        </ul>
    </form>
<%
    ArrayList<StaffDto> alStf = (ArrayList) request.getAttribute("stfAl");
%>
    <h3><span>■</span>社員一覽</h3>
    <div class="count">
<% if(alStf == null){ %>
        件数：0件
<% }else{%>
	件数：<%= alStf.size() %>件
<% } %>
        <a href="/bmsweb/Insert.jsp" style="background-color: antiquewhite;">新規登錄</a>
    </div>
    <table>
        <tr class="bg">
            <th>所属会社</th>
            <th>社員名</th>
            <th>性別</th>
            <th>職業種類</th>
            <th>入社日</th>
            <th>退社日</th>
            <th>編集</th>
        </tr>
<%
if(alStf != null){
	Iterator it = alStf.iterator();
	while(it.hasNext()){
		StaffDto dto =(StaffDto) it.next();
%>
        <tr>
            <td style="display:none;"><%=dto.getSyain_id() %></td>
            <td><%=dto.getCom() %></td>
            <td><%=dto.getName() %></td>
            <td><%=dto.getSex() %></td>
            <td><%=dto.getPjt() %></td>
            <td><%=dto.getNYUUSYA_DATE() %></td>
            <td><%=dto.getTAISYA_DATE() == null ? "" : dto.getTAISYA_DATE() %></td>
            <td class="txtc">
                <a href="/bmsweb/staffUpdate?id=<%=dto.getSyain_id() %>" style="background-color: lightblue;">更新</a>&nbsp;&nbsp;
			<!--  path & xml 一致  不要寫明碼！-->
		<a class="deleteBtn" href="/bmsweb/staffDelete?id=<%=dto.getSyain_id() %>">削除</a>
<!--                <a href="/bmsweb/staffDelete?id=<%=dto.getSyain_id() %>" style="background-color: pink;">削除</a>   -->
            </td>
        </tr>
<% }} %>
    </table>
</div>

<script>
// 建立刪除前的Msg
// querySelectorAll 抓複數
const btn = document.querySelectorAll('.deleteBtn');

function showDelMsg(){
	// 跳確認框  回傳 ture & false
	var confirm = window.confirm("Are you sure delete it ?");
		if(confirm){
			console.log("yes delete it !");
		}else{
			//阻止向下執行
			event.preventDefault();
			console.log("No, do not delete it !");
		}
}
// 因為 btn[]  是Array
// e 是  event.target   ;  event.currentTarget  當前click 的目標
btn.forEach(function (e){
	e.addEventListener('click',showDelMsg);
});

//	btn[2].attributes['value']
//	e.target.getAttribute("value");  //抓值

</script>

</body>
</html>
