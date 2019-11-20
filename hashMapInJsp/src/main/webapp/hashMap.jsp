<%@page import="java.util.Map.Entry"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Loop HashMap in JSP</title>
	</head>
	
	<body>
		<h3>Keeping in page scope</h3>
		<%
			Map<Integer,String> map=new HashMap<Integer,String>();
			map.put(1, "JSP");
	        map.put(2, "Java");
	        map.put(3, "JSTL");
	        map.put(4, "J2EE");
	        map.put(5, "JEE");
	        
	        // putting HashMap into Page pageContext scope
	        pageContext.setAttribute("mapKey", map);
	        //System.out.println(map);
		%>
		
		<%
			//System.out.println("======================================");
			//out.println("From Scriptlet Tag");
			Map<Integer,String> obj=(Map<Integer,String>)pageContext.getAttribute("mapKey");
			for(Entry<Integer,String> entry:obj.entrySet()){
				//System.out.println(entry);
				//out.println(entry);
			}
			System.out.println("======================================");
		%>
		
		<!-- Iterating map in JSTL -->
		<table>
			<c:forEach var="entry" items="${mapKey}">
				<%-- <tr><td><c:out value="${entry.key}" /></td> <td><c:out value="${entry.value}" /></td></tr> --%>
			</c:forEach>
		</table>
		
		<%out.println("================================================"); %>
		
		<%
			Map<String, Integer> prices = new HashMap<String, Integer>();
	        prices.put("Google", 500);
	        prices.put("Apple", 300);
	        prices.put("Amazon", 320);
	        prices.put("BABA", 94);
	        prices.put("MSFT", 30);
	        
	        application.setAttribute("sharePrice", prices);
	        System.out.println("===============");
	        System.out.println(prices);
		%>
		
		<%
			System.out.println("======================================");
			out.println("<br>");
			out.println("From Scriptlet Tag");
			out.println("<br>");
			Map<Integer,String> obj2=(Map<Integer,String>)application.getAttribute("sharePrice");
			for(Entry<Integer,String> entry:obj2.entrySet()){
				System.out.println(entry);
				//out.println(entry);
			}
			System.out.println("======================================");
			System.out.println();
		%>
		
		<table>
			<c:forEach var="items" items="${sharePrice}">
				<%-- <tr><td><c:out value="${items.key}" /></td> <td><c:out value="${items.value}" /></td></tr> --%>
			</c:forEach>
		</table>
		
	</body>
	
</html>
