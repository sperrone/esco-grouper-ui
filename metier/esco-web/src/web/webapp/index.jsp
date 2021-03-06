<%--
 Copyright (C) 2009 GIP RECIA http://www.recia.fr
 @Author (C) 2009 GIP RECIA <contact@recia.fr>
 @Contributor (C) 2009 SOPRA http://www.sopragroup.com/
 @Contributor (C) 2011 Pierre Legay <pierre.legay@recia.fr>

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
        http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="org.esco.grouperui.web.controllers.SessionController"%><html>
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="cache-control" content="no-store" />
		<meta http-equiv="expires" content="0" />
		<%
		   pageContext.setAttribute("url" ,response.encodeURL(request.getContextPath() +"/stylesheets/welcome.jsf") );
		%>
		<META HTTP-EQUIV="Refresh" CONTENT="0;URL=<%=pageContext.getAttribute("url")%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>
			RECIA - ESCO Grouper
		</title>
	</head>
	<body>
		Redirection vers la page d'accueil
	</body>
</html>