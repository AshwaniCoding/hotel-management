<!-- viewBill.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>Bill Details</h2>
<p><strong>Customer:</strong> ${bill.customerName}</p>
<p><strong>Date:</strong> ${bill.date}</p>
<p><strong>Total Amount:</strong> ₹${bill.totalAmount}</p>
<h4>Items</h4>
<table class="table">
    <thead>
    <tr>
        <th>Item</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Subtotal</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="bi" items="${bill.billItems}">
        <tr>
            <td>${bi.item.name}</td>
            <td>₹${bi.item.price}</td>
            <td>${bi.quantity}</td>
            <td>₹${bi.item.price * bi.quantity}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/bills" class="btn btn-primary">Back to Bills</a>