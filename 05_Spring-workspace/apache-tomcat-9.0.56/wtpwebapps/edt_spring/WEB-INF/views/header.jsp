<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header id="header">
        <div id="logo">
            <a href="main.go">
                <img src="resources/img/logo-basic.png">
            </a>
        </div>
        <div id="search">
            <input type="search" name="search" autofocus autocomplete="off" onfocus="this.placeholder=''" onblur="this.placeholder='brand, name, model . . .'">
            <a href="search.do">
                <img src="resources/img/search_btn2.png">
            </a>
        </div>
        <div id="menu">
            <ul>
                <li>
                    <a href="draw.go">DRAW</a>
                </li>
                <li>
                    <a href="productsList.do">SHOP</a>
                </li>
                <li>
                    <a href="join.go">JOIN</a>
                </li>
                <li>
                    <a href="login.go">LOGIN</a>
                </li>
            </ul>
        </div>
</header>