<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
        + request.getServerName() + ":" + request.getServerPort()
        + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <title>标题</title> 
  <script type="text/javascript" src="<%=basePath%>js/jquery-2.2.3.min.js"></script>
  <script type="text/javascript">
  	function loggin(){
  		$.ajax({
  		     type: "post",
  		     url: "<%=path%>/user/loggin",
  		     async: false,                //true为异步加载，false为同步加载，参数为空时，默认异步加载
  		     cache: false,
  		     data: $("#form1").serialize(),
  		     dataType: "text",    
  		     timeout : 5000,
  		     success: function(data){
  		     },
  		     error: function(){
  		     }
  		  });
  	}
  </script>  
  </head>
  <body>  
    hello world！
    <form id="form1" action="<%=path%>/user/loggin" method="post">
		    用户名：     
		    <input type="text" id="username" name="username" value="" maxlength="20"/>
		    密    码：   
		    <input type="password" id="password" name="password" maxlength="20"/>
		    <input type="button" onclick="loggin()" value="登录"/> 
		    <input type="submit" value="submit">
    </form>
  </body>
</html> 