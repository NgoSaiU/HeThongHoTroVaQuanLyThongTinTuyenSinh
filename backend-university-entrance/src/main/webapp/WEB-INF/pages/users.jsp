<%-- 
    Document   : users
    Created on : Aug 29, 2023, 5:12:53 AM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1 class="text-center text-info">QUẢN LÝ SẢN PHẨM</h1>

<c:url value="/users" var="action" />
<form:form modelAttribute="user" method="post" action="${action}" enctype="multipart/form-data">

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="username" id="username" 
                    placeholder="Tên user" name="username" />
        <label for="username">Tên user</label>
    </div>
    <div class="form-floating">
        <form:input type="password" class="form-control" path="password" id="password" 
                    placeholder="Mật khẩu" name="password" />
        <label for="password">Mật khẩu</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="firstName" id="firstName" 
                    placeholder="first_name" name="firstName" />
        <label for="firstName">first_name</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="lastName" id="lastName" 
                    placeholder="last_name" name="lastName" />
        <label for="lastName">last_name</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="email" id="email" 
                    placeholder="email" name="email" />
        <label for="email">email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="phone" id="phone" 
                    placeholder="phone" name="phone" />
        <label for="phone">phone</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="date form-control" path="file" id="file" 
                    name="file" />
        <label for="file">Ảnh</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="userRole" name="userRole" path="userRole">
            <c:forEach items="${roles}" var="r">
                <c:choose>
                    <c:when test="${r.id == user.userRole.id}">
                        <option value="${c.id}" selected>${r.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${r.id}">${r.name}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>


        </form:select>
        <label for="userRole" class="form-label">Danh mục role</label>
    </div>
    <div class="form-floating mt-1">
        <button class="btn btn-info">Thêm user</button>
    </div>
</form:form>
