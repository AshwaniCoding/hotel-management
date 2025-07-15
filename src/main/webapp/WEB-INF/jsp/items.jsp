<!-- items.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>Available Items</h2>
<a href="/items/new" class="btn btn-primary mb-2">Add New Item</a>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>₹${item.price}</td>
            <td>
                <a href="/items/${item.id}/edit" class="btn btn-warning btn-sm">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
