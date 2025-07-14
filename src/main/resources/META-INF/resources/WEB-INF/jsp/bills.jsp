<!-- bills.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>All Bills</h2>
<a href="/bills/new" class="btn btn-primary mb-2">Create New Bill</a>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>Customer</th>
        <th>Date</th>
        <th>Total</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="bill" items="${bills}">
        <tr>
            <td>${bill.id}</td>
            <td>${bill.customerName}</td>
            <td>${bill.date}</td>
            <td>${bill.totalAmount}</td>
            <td>
                <a href="/bills/${bill.id}" class="btn btn-info btn-sm">View</a>
                <a href="/bills/${bill.id}/edit" class="btn btn-warning btn-sm">Edit</a>
                <a href="/bills/${bill.id}/delete" class="btn btn-danger btn-sm">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>