<%--
  Created by IntelliJ IDEA.
  User: darren
  Date: 2020/10/27
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../script/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            var url = $("#a1").attr("href");
            $("#a1").click(function(){
                $.ajax({
                    url:url,
                    type:"GET",
                    dataType:"json",
                    success:function(msg){
                            var tableHead =
                                "<tr>"+
                                    "<td>ID</td>"+
                                    "<td>LASTNAME</td>"+
                                    "<td>GENDER</td>"+
                                    "<td>EMAIL</td>"+
                                "</tr>";
                            for(var i=0;i<msg.length;i++){
                                tableHead = tableHead+
                                    "<tr>"+
                                    "<td>"+msg[i].id+"</td>"+
                                    "<td>"+msg[i].lastName+"</td>"+
                                    "<td>"+msg[i].gender+"</td>"+
                                    "<td>"+msg[i].email+"</td>"+
                                    "</tr>";
                            }
                            $("#tb").html(tableHead);
                    }
                });
                return false;
            });

        });

    </script>
</head>
<body>
    <a id="a1" href="/SGGJAVAWEB01/FindAllEmpServlet">获取全班学员</a>
    <table id="tb"></table>
</body>
</html>
