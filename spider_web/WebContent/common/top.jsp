<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    boolean login = Boolean.parseBoolean(request.getParameter("login"));
    String loingStr= "로그인";
    if(login){
    	loingStr ="로그아웃";
    }
    %>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/board/board_select.jsp">게시판가기</a></li>
            <li><a href="#about">유저정보가기</a></li>
            <li><a href="#contact">권한정보가기</a></li>
            <li><a href="/user/logout_ok.jsp"><%=loingStr%></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
